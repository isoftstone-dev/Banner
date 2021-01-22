package com.huawei.banner.slice;

import com.huawei.banner.ResourceTable;
import com.huawei.banner.provider.BannerProvider;
import com.huawei.bannerpageslider.BannerPageSlider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Image;

import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {

    private List<Image> data;
    private BannerPageSlider autoPlayViewPage;
    private BannerProvider bannerProvider;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        data = new ArrayList<>();
        Image image1 = new Image(this);
        Image image2 = new Image(this);
        Image image3 = new Image(this);
        // 设置image的宽高，并且图片充满整个image
        image1.setLayoutConfig(new ComponentContainer.LayoutConfig(ComponentContainer.LayoutConfig.MATCH_PARENT, ComponentContainer.LayoutConfig.MATCH_CONTENT));
        image1.setScaleMode(Image.ScaleMode.STRETCH);
        image2.setLayoutConfig(new ComponentContainer.LayoutConfig(ComponentContainer.LayoutConfig.MATCH_PARENT, ComponentContainer.LayoutConfig.MATCH_CONTENT));
        image2.setScaleMode(Image.ScaleMode.STRETCH);
        image3.setLayoutConfig(new ComponentContainer.LayoutConfig(ComponentContainer.LayoutConfig.MATCH_PARENT, ComponentContainer.LayoutConfig.MATCH_CONTENT));
        image3.setScaleMode(Image.ScaleMode.STRETCH);
        // 给图片设置资源
        image1.setPixelMap(ResourceTable.Media_ku);
        image2.setPixelMap(ResourceTable.Media_ku2);
        image3.setPixelMap(ResourceTable.Media_ku3);
        // 给list增加数据
        data.add(image1);
        data.add(image2);
        data.add(image3);
        // 实例化适配器
        bannerProvider = new BannerProvider(this,data);
        autoPlayViewPage = (BannerPageSlider) findComponentById(ResourceTable.Id_view_pager);
        autoPlayViewPage.setProvider(bannerProvider);
        // 以下两个方法不是必须的，因为有默认值
        autoPlayViewPage.setDirection(BannerPageSlider.Direction.RIGHT);// 设置播放方向
        autoPlayViewPage.setCurrentPage(200); // 设置每个Item展示的时间
        autoPlayViewPage.start(); // 开始轮播
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
