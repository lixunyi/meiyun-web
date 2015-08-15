package com.meiyun.dao.core;

import com.github.pagehelper.PageHelper;

/**
 * 分页策略
 * 
 * @author Administrator
 * @since 2015-08-15
 */
public final class Pagable {

	private String orderBy; // 排序

	private int pageNum; // 页码

	private int pageSize; // 每页显示数量

	private boolean count; // 是否进行count查询

	private Boolean reasonable; // 分页合理化,null时用默认配置
	
	private Boolean pageSizeZero; // true且pageSize=0时返回全部结果，false时分页,null时用默认配置
	
	/**
	 * 查询结果集 排序
	 * @param orderBy
	 * @example "id DESC"
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

    /**
     * 开始分页
     *
     * @param pageNum  页码
     * @param pageSize 每页显示数量
     */
    public Pagable(int pageNum, int pageSize) {
    	this(pageNum, pageSize, true);
    }

    /**
     * 开始分页
     *
     * @param pageNum  页码
     * @param pageSize 每页显示数量
     * @param count    是否进行count查询
     */
    public Pagable(int pageNum, int pageSize, boolean count) {
        this(pageNum, pageSize, count, null);
    }

    /**
     * 开始分页
     *
     * @param pageNum  页码
     * @param pageSize 每页显示数量
     * @param orderBy  排序
     */
    public Pagable(int pageNum, int pageSize, String orderBy) {
    	this(pageNum, pageSize);
        setOrderBy(orderBy);
    }

    /**
     * 开始分页
     *
     * @param pageNum    页码
     * @param pageSize   每页显示数量
     * @param count      是否进行count查询
     * @param reasonable 分页合理化,null时用默认配置
     */
    public Pagable(int pageNum, int pageSize, boolean count, Boolean reasonable) {
        this(pageNum, pageSize, count, reasonable, null);
    }

    /**
     * 开始分页
     *
     * @param pageNum      页码
     * @param pageSize     每页显示数量
     * @param count        是否进行count查询
     * @param reasonable   分页合理化,null时用默认配置
     * @param pageSizeZero true且pageSize=0时返回全部结果，false时分页,null时用默认配置
     */
    public Pagable(int pageNum, int pageSize, boolean count, Boolean reasonable, Boolean pageSizeZero) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
        this.reasonable = reasonable;
        this.pageSizeZero = pageSizeZero;
    }

	/**
	 * 执行分页任务
	 * 
	 * @param pagable
	 */
	public static void excute(final Pagable pagable) {
		
		// 是否设置排序
		if (pagable.getOrderBy() != null && !"".equals(pagable.getOrderBy().trim())) {
			PageHelper.orderBy(pagable.getOrderBy());
		}
		
		// 分页策略
		PageHelper.startPage(pagable.getPageNum(), pagable.getPageSize(), pagable.isCount(),
				pagable.getReasonable(), pagable.getPageSizeZero());
	}

	public String getOrderBy() {
		return orderBy;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public boolean isCount() {
		return count;
	}

	public Boolean getReasonable() {
		return reasonable;
	}

	public Boolean getPageSizeZero() {
		return pageSizeZero;
	}

}
