package com.poisonh.jadeculture.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * 类说明：LruCache 图片缓存优化处理类
 * 作者：PoisonH on 2016/8/20 11:36
 * 邮箱：PoisonH@163.com
 */

public class LruCacheUtils extends LruCache<String, Bitmap>
{
    //获取手机内存大小
    private static int MAXMEMONRY = (int) (Runtime.getRuntime().maxMemory() / 1024);
    private static LruCacheUtils cacheUtils;

    private LruCacheUtils(int maxSize)
    {
        super(maxSize);
    }

    /**
     * 单例
     */
    public static LruCacheUtils getInstance()
    {
        if (cacheUtils == null)
        {
            //创建对象时分配缓存，我们取内存的5分之一
            cacheUtils = new LruCacheUtils(MAXMEMONRY / 5);
        }
        return cacheUtils;
    }

    @Override
    protected int sizeOf(String key, Bitmap value)
    {
        return value.getRowBytes() * value.getHeight() / 1024;
    }

    @Override
    protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue)
    {
        super.entryRemoved(evicted, key, oldValue, newValue);
    }

    /**
     * 清理缓存
     */
    public void clearCache()
    {
        if (cacheUtils.size() > 0)
        {
            cacheUtils.evictAll();
        }
    }


    /**
     * 添加缓存图片
     */
    public synchronized void addBitmapToMemoryCache(String key, Bitmap bitmap)
    {
        if (cacheUtils.get(key) != null)
        {
            return;
        }
        if (!isEmpty(key) && bitmap != null)
        {
            cacheUtils.put(key, bitmap);
        }
    }


    /**
     * 获取缓存图片
     */
    public synchronized Bitmap getBitmapFromMemCache(String key)
    {
        if (isEmpty(key))
        {
            return null;
        }
        Bitmap bm = cacheUtils.get(key);
        if (bm != null && !bm.isRecycled())
        {
            return bm;
        }
        return null;
    }

    /**
     * 移除缓存
     *
     * @param key
     */
    public synchronized void removeImageCache(String key)
    {
        if (isEmpty(key))
        {
            return;
        }
        Bitmap bm = cacheUtils.remove(key);
        if (bm != null && !bm.isRecycled())
        {
            bm.recycle();
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public boolean isEmpty(String... str)
    {
        if (str == null)
        {
            return true;
        }
        for (String s : str)
        {
            if (s == null || s.isEmpty() || s.trim().isEmpty())
            {
                return true;
            }
        }
        return false;
    }
//
//    /**下面是使用范例**/
//    /**
//     * 使用例子
//     */
//    private void example()
//    {
//
//        String url = "http://i2.buimg.com/567571/d208d52913b997bb.jpg?imageView2/2/w/ 200";
//        ImageView photoView = new ImageView();
//        //判断缓存中是否已经缓存过该图片，有则直接拿Bitmap，没有则直接调用Glide加载并缓存Bitmap
//        Bitmap bitmap = LruCacheUtils.getInstance().getBitmapFromMemCache(url);
//        if (bitmap != null)
//
//        {
//            photoView.setImageBitmap(bitmap);
//        } else
//
//        {
//            PhotoLoader.displayImageTarget(photoView, url, getTarget(photoView, url, position));
//        }
//    }
//
//    /**
//     * 加载图片 Target
//     *
//     * @param imageView
//     * @param target
//     * @param url
//     */
//    public void displayImageTarget(final ImageView imageView, final String url, BitmapImageViewTarget target)
//    {
//        Glide.get(imageView.getContext()).with(imageView.getContext())
//                .load(url)
//                .asBitmap()//强制转换Bitmap
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .into(target);
//    }
//
//
//    /**
//     * 获取BitmapImageViewTarget
//     */
//    private BitmapImageViewTarget getTarget(ImageView imageView, final String url, final int position)
//    {
//        return new BitmapImageViewTarget(imageView)
//        {
//            @Override
//            protected void setResource(Bitmap resource)
//            {
//                super.setResource(resource);
//                //缓存Bitmap，以便于在没有用到时，自动回收
//                LruCacheUtils.getInstance().addBitmapToMemoryCache(url,
//                        resource);
//            }
//        };
//    }
}
