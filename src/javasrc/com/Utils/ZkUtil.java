package com.Utils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * zookeeper工具类
 * 使用curator操作zookeeper
 */
public class ZkUtil
{
    private CuratorFramework zkClient;

    /**
     * 构造方法
     * @param curatorFramework  curator框架
     */

    public ZkUtil(CuratorFramework curatorFramework)
    {
        this.zkClient=curatorFramework;
        try {
            zkClient.getData().usingWatcher(curatorWatcher)
                    .forPath("/name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 设置节点并赋值
     * @param path  节点名
     * @param data  节点内容
     */
    public void setPathData(String path,String data)
    {
        //如果节点不存在则创建
        if (!this.existsNode(path))
        {
            //递归创造节点并设置节点的内容 如 /abc/def/ghi
            try {
                zkClient.create().creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(path,data.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        //设置节点的内容
        try {
            zkClient.setData().forPath(path,data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取节点的内容
     * @param path  节点名
     * @return  String 节点内容
     * @throws Exception
     */
    public String getPathData(String path) throws Exception {
        if (!this.existsNode(path))
            return "";
        return new String(zkClient.getData().forPath(path));
    }

    /**
     * 判断节点是否存在
     * @param path  节点名
     * @return  boolean
     */

    private boolean existsNode(String path)
    {
        try {
            if (zkClient.checkExists().forPath(path)==null)
            {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 指定节点的监听方式
     * 这种监听方式是一次性的，zookeeper通知了watcher事件后，就会将这个watcher从会话中删除
     * 因此，我们在发生监听处理完成后要进行重复添加watcher
     */
    public CuratorWatcher curatorWatcher=new CuratorWatcher() {
        @Override
        public void process(WatchedEvent watchedEvent) throws Exception
        {
            if (watchedEvent.getType()== Watcher.Event.EventType.NodeDataChanged)
            {
                zkClient.getData().usingWatcher(curatorWatcher)
                        .forPath(watchedEvent.getPath());
            }
        }
    };

}
