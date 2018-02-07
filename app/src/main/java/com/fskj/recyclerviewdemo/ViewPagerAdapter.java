package com.fskj.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * author: Administrator
 * date: 2018/2/5 0005
 * desc:
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<Integer> imgs;
    private Context context;
    private String [] urls = new String[] {"https://www.baidu.com","https://www.cnblogs.com","https://github.com/"};

    public ViewPagerAdapter(List<Integer> imgs, Context context) {
        this.imgs = imgs;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container,  int position) {
        final int newPosition = position % imgs.size();
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imgs.get(newPosition));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri content_url = Uri.parse(urls[newPosition]);
                intent.setData(content_url);
                context.startActivity(intent);
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
