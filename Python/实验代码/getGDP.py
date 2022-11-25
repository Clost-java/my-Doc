# coding:gbk
from pyecharts import options as opts
from pyecharts.charts import Bar, Map, Timeline
import pandas as pd

datas = pd.read_csv('2001-2019各省GDP数据.csv', encoding='gbk')

def get_gdp_bar1(datas):
    c = (
        Bar()
            .add_xaxis(datas['地区'].values.tolist())
            .add_yaxis('全国各省GDP(亿元)', datas['2019年'].values.tolist())
            .set_global_opts(
            title_opts=opts.TitleOpts(title='2019年全国各省GDP(亿元)'),
            datazoom_opts=[opts.DataZoomOpts(), opts.DataZoomOpts(type_='inside')],
        )
        .render('2019年全国各省GDP_Bar1.html')
    )

def get_gdp_bar2(datas):
    sort_info = datas.sort_values(by='2019年', ascending=True)
    c = (
        Bar()
            .add_xaxis(sort_info['地区'].values.tolist())
            .add_yaxis('全国各省GDP(亿元)', sort_info['2019年'].values.tolist())
            .reversal_axis()
            .set_series_opts(label_opts=opts.LabelOpts(position="right"))
            .set_global_opts(
            title_opts=opts.TitleOpts(title='2019年全国各省GDP(亿元)'),
            datazoom_opts=[opts.DataZoomOpts(is_show=True
            , orient='vertical')],

        )
        .render('2019年全国各省GDP_Bar2.html')
    )

def get_gdp_map1(datas):
    datas['地区'].replace(regex=True, inplace=True, to_replace=['省', '市', '维吾尔自治区', '回族自治区', '壮族自治区', '自治区'], value=r'')
    map = (
        Map()
        .add('全国各省GDP(亿元)', datas[['地区', '2019年']].values.tolist(), 'china')
        .set_global_opts(
            title_opts=opts.TitleOpts(title='2019年全国各省GDP(亿元)'),
            visualmap_opts=opts.VisualMapOpts(max_=110000),
        )
    )
    map.render('2019年全国各省GDP_Map.html')

def get_gdp_map2(datas):
    datas['地区'].replace(regex=True, inplace=True, to_replace=['省', '市', '维吾尔自治区', '回族自治区', '壮族自治区', '自治区'], value=r'')
    tl = Timeline()
    # 播放的速度，单位毫秒（ms）
    tl.add_schema(play_interval=300, symbol='emptydiamond')
    for i in range(2001, 2020):
        map0 = (
            Map()
            .add('全国各省GDP(亿元)', datas[['地区', str(i) + '年']].values.tolist(), 'china')
            .set_global_opts(
                title_opts=opts.TitleOpts(title='{}年全国各省GDP(亿元)'.format(i)),
                visualmap_opts=opts.VisualMapOpts(max_=110000,is_piecewise=True),
            )
        )
        tl.add(map0, '{}年'.format(i))
    tl.render('2001-2019年全国各省GDP.html')


get_gdp_bar1(datas)
get_gdp_bar2(datas)
get_gdp_map1(datas)
get_gdp_map2(datas)