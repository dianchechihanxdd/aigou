package cn.itsource.aigou.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class RedisUtil {
    private static JedisPool jedisPool;
    static {
        //连接池的配置：
        GenericObjectPoolConfig poolConfig = new JedisPoolConfig();

        poolConfig.setMaxTotal(20);
        poolConfig.setMaxIdle(5);
        poolConfig.setMaxWaitMillis(3000);
        poolConfig.setTestOnBorrow(true);
        //创建pool：
        // (GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password)
         jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379,2000,"root");

    }

    public  static void set(String key,String value){
        Jedis jedis =null;
        try {
            jedis= jedisPool.getResource();
            jedis.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(jedis!=null){
                jedis.close();
            }

        }
    }

    public  static String get(String key){
        Jedis jedis =null;
        try {
            jedis= jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            if(jedis!=null){
                jedis.close();
            }

        }
    }

    public static void main(String[] args) {


RedisUtil.set("name","ssss");
    }


}
