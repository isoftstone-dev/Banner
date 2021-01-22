package com.huawei.banner.provider;

import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Image;
import ohos.agp.components.PageSliderProvider;
import ohos.app.Context;

import java.util.List;

public class BannerProvider extends PageSliderProvider {
    private List<Image> listData;
    private Context mContext;


    public BannerProvider(Context context, List<Image> listData) {
        this.mContext = context;
        this.listData = listData;
    }

    @Override
    public int getCount() {
//        return listData == null ? 0 : Integer.MAX_VALUE;
    return listData.size();
    }


    @Override
    public Object createPageInContainer(ComponentContainer componentContainer, int i) {
        i = i % listData.size();
        Object xxoo = listData.get(i);
        componentContainer.addComponent((Component) xxoo);
        return xxoo;
    }

    @Override
    public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
        componentContainer.removeComponent(listData.get(i));
    }

    @Override
    public boolean isPageMatchToObject(Component component, Object o) {
        return component == o;
    }
}
