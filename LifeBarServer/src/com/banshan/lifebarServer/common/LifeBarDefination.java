package com.banshan.lifebarServer.common;

public class LifeBarDefination {

	/*
	 * 默认产品类型
	 */
	public static short LB_PRODUCT_TYPE_DEFAULT = 0;
	/*
	 * 照片归属
	 */
	public static short LB_PIC_TYPE_PRODUCT = 0;
	public static short LB_PIC_TYPE_ORG = 1;
	public static short LB_PIC_TYPE_DISCOUNTCARD = 2;

	/*
	 * 照片类型
	 */
	public static short LB_PRODUCT_PIC_TYPE_DEFAULT = 0;
	public static short LB_PRODUCT_PIC_TYPE_THUMB = 0;
	public static short LB_PRODUCT_PIC_TYPE_MIDDLE = 1;
	public static short LB_PRODUCT_PIC_TYPE_FULL = 2;
	public static short LB_PRODUCT_PIC_TYPE_HEADER = 3;
	public static short LB_PRODUCT_PIC_TYPE_LEFT = 4;
	public static short LB_PRODUCT_PIC_TYPE_RIGHT = 5;
	public static short LB_PRODUCT_PIC_TYPE_BACK = 6;
	public static short LB_PRODUCT_PIC_TYPE_NOFACE = 7;
	/*
	 * 优惠类型
	 */
	public static short LB_PRODUCT_DISCOUNT_TYPE_PERCENT = 0;
	public static short LB_PRODUCT_DISCOUNT_TYPE_CUT = 1;

	/*
	 * 组织类型
	 */
	public static short LB_ORG_TYPE_DEFAULT = 0;
	
	/*
	 * 组织级别
	 */
	public static short LB_ORG_ROOT = 0;
	
	/*
	 * 折扣是否允许叠加使用
	 */
	public static short LB_DISCOUNT_CARD_NO_OVERLAY = 0;
	public static short LB_DISCOUNT_CARD_CAR_OVERLAY = 1;

	/*
	 * 产品状态
	 */
	public static short LB_PRODUCT_STATUS_DEFAULT = 0;
	public static short LB_PRODUCT_STATUS_ONSALE = 0;

	/*
	 * 产品优先级
	 */
	public static int LB_PRODUCT_PRIORITY_DEFAULT = 0;
	public static int LB_PRODUCT_PRIORITY_NORMAL = 0;

	/*
	 * 
	 */
	public static int LB_MAX_PRODUCT_PIC_NUM = 100;
	
	/*
	 * 图片存放的上传路径，使用后移到下面的路径
	 */
	public static String LB_PIC_UPLOAD_PATH = "/resource/upload/";
	/*
	 * 默认图片存放相对路径
	 */
	public static String LB_PIC_RELATIVE_PATH = "/resource/images/";

}
