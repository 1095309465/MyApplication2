package com.example.UtilsTools;

/**
 * 	GET的格式:"http://zhushou.72g.com/app/game/game_like/?platform=2&gifttype=2&compare=6e269664c9f849a87e094e95e3c18c1a"
	POST的格式:http://zhushou.72g.com/app/game/game_like/
	表单进行数据的存放(Map格式存放数据,key-value保存,通过=区分key,value,&表示一组数据结束)
	Map<String,String> map = new HashMap<String,String>
	map.put("platform","2");
	map.put("gifttype","2");
	map.put("compare","6e269664c9f849a87e094e95e3c18c1a");
	1.比如登陆，注册等操作都是以Post方式进行提交
	2.比如新闻，百度搜索多数以Get方式
	
	a)安全性Post>Get
	b)传输数据大小（Get收到URL地址的局限性2KB,字符串长度有限制，POST理论上不受限制，实际受到服务器的约束）
	C)响应速度上Get快速
	
 * @author Jimmy
 *
 */
public class UrlConstantUtils {
	
	//GET和Post2种请求方式
	//所有的信息都在url显示
	public static final String URL_WODE="http://zhushou.72g.com/app/common/banner_info/";
	//1.礼包:
	//1.1.显示列表
	//填写post参数:
	//页游:platform=2&gifttype=2&compare=6e269664c9f849a87e094e95e3c18c1a
	//手游:第一页参数:platform=2&gifttype=1&compare=8d57fdf90138796712df581793fba821
	//手游:第二页参数:platform=2&gifttype=1&page=2&compare=593c0bdb30f671c2af5ce422210e08b6
	//手游:第三页参数:platform=2&gifttype=1&page=3&compare=19a7d73df897f0b0d55943d9f000ca19
	//手游:第三页参数:platform=2&gifttype=1&page=4&compare=19a7d73df897f0b0d55943d9f000ca19
	public static final String URL_GIFTLIST = "http://zhushou.72g.com/app/gift/gift_list/";
	//1.2.搜索页面猜你喜欢 
	//填写的Post参数:id=1&compare=8fe26c6dc128f40a099837ec2673c543
	public static final String URL_GIFTSEARCHLIST = "http://zhushou.72g.com/app/game/game_like/";
	//1.3 详情页面
	//填写的Post参数:id=?&compare=83c5251c58aca6e7343cfef0a8448db7(?就是info的id)
	public static final String URL_GIFT_DETAIL = "http://zhushou.72g.com/app/gift/gift_info/";
	
	//1.4 猜你喜欢的点击进入的详情界面
	public static final String URL_GIFT_CNXH_DETAIL="http://zhushou.72g.com/app/game/game_info/";
	public static final String GAME_DETAIL="http://zhushou.72g.com/app/game/game_like/";
	public static final String GAME_DETAIL_Talk="http://zhushou.72g.com/app/game/game_comment_list/";
	
	//总的界面信息:(http://zhushou.72g.com/app/game/game_info/ Post参数:id=?)
	//游戏信息:(http://zhushou.72g.com/app/game/game_like/ Post参数:id=?)
	//游戏礼包(http://zhushou.72g.com/app/gift/gift_list/ Post参数:gamename=?&platform=2&gifttype=1)
	//评论(http://zhushou.72g.com/app/game/game_comment_list/ Post参数:id=?)

		
	//2.活动:
	//2.1.广告页面 
	//填写post参数:platform=2&pos=1&compare=65dcae2018c98b3a96f8263d05e3538c
	public static final String URL_BANNERINFO = "http://zhushou.72g.com/app/common/banner_info/";
	//2.2.显示列表
	//填写post参数:platform=2&compare=5f2c32f51faa05ba2c5b087cf50e7ab8
	public static final String URL_ACTIVELIST = "http://zhushou.72g.com/app/activity/activity_list/";	   
	//2.3.显示列表活动详情内容
	public static final String HuoDongDetail = "http://zhushou.72g.com/app/activity/activity_info/";	   
	//详情内容显示:(http://zhushou.72g.com/app/activity/activity_info/ Post参数:id=?)
	public static final String HuoDongDetailTalk = "http://zhushou.72g.com/app/activity/activity_comment_list/";	   
	//评论接口:(http://zhushou.72g.com/app/activity/activity_comment_info/ Post参数:id=?)
	public static final String Floor = "http://zhushou.72g.com/app/activity/get_one_comment/";	   
	
	
	//3.赚钱:
	//3.1.显示列表 
	//填写post参数:platform=2
	public static final String URL_MONEYLIST = "http://zhushou.72g.com/app/game/game_list/";
	//3.2.积分商城
	//填写post参数:type=1   最新奖品
	//填写post参数:type=2   热门奖品
	public static final String URL_GAINSHOP = "http://zhushou.72g.com/app/prize/prize_list/";
	
	//4.小游戏
	public static final String XiaoGame_ViewPager = "http://www.h5151.com/ajax/hd_game/";
	public static final String XiaoGame_ZuiXin = "http://www.h5151.com/ajax/app_game_list/";
	public static final String XiaoGame_ReMen="http://www.h5151.com/ajax/hot_game/";
}
