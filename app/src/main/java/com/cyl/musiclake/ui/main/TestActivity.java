package com.cyl.musiclake.ui.main;

import android.widget.TextView;

import com.cyl.musicapi.BaseApiImpl;
import com.cyl.musiclake.R;
import com.cyl.musiclake.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {
    BaseApiImpl searchApi;
    @BindView(R.id.tv_show)
    TextView resultTv;
    @BindView(R.id.tv_status)
    TextView statusTv;

    @OnClick(R.id.btn_test1)
    void test() {
        searchApi.getTopList("1", result -> {
            statusTv.setText("getTopList");
            resultTv.setText(result.toString());
            return null;
        });
    }

    @OnClick(R.id.btn_test2)
    void test2() {
        searchApi.searchSong("薛之谦", 10, 0, result -> {
            statusTv.setText("searchSong");
            resultTv.setText(result.toString());
            return null;
        });
    }

    @OnClick(R.id.btn_test3)
    void test3() {
        searchApi.getSongDetail("qq", "001Qu4I30eVFYb", result -> {
            statusTv.setText("songDetail");
            resultTv.setText(result.toString());
            return null;
        }, null);
    }

    @OnClick(R.id.btn_test4)
    void test4() {
        searchApi.getLyricInfo("qq", "001Qu4I30eVFYb", result -> {
            statusTv.setText("getLyricInfo");
            resultTv.setText(result.toString());
            return null;
        });
    }

    @OnClick(R.id.btn_test5)
    void test5() {
        searchApi.getComment("qq", "001Qu4I30eVFYb", songComment -> {
            statusTv.setText("getComment");
            resultTv.setText(songComment.toString());
            return null;
        });
    }

    @OnClick(R.id.btn_test6)
    void test6() {
        searchApi.getSongUrl("qq", "001Qu4I30eVFYb", result -> {
            statusTv.setText("getSongUrl");
            resultTv.setText(result.toString());
            return null;
        }, null);
    }

    @OnClick(R.id.btn_playlist2)
    void get() {
        searchApi.getBatchSongDetail("qq", new String[]{"001Qu4I30eVFYb"}, result -> {
            statusTv.setText("qq");
            resultTv.setText(result.toString());
            return null;
        });
    }

    @OnClick(R.id.btn_playlist3)
    void get1() {
        searchApi.getBatchSongDetail("netease", new String[]{"559647510", "437608504"}, result -> {
            statusTv.setText("netease[559647510,437608504]");
            resultTv.setText(result.toString());
            return null;
        });
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        searchApi = BaseApiImpl.Companion.getInstance(this);
    }

    @Override
    protected void initInjector() {

    }


}