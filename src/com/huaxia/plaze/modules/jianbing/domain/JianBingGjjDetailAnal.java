package com.huaxia.plaze.modules.jianbing.domain;

import org.apache.commons.lang.StringUtils;

/**
 * 第三方 & 51易达金
 * 
 * @author liyanan
 *
 */
public class JianBingGjjDetailAnal {

	private String uuid;
	private String crt_time;
	private String crt_user;
	private String trn_id;
	private String trn_key; // 交易关联键
	private String detail_analy_id;
	private String company_6m_arr;
	private String company_12m_arr;
	private String company_24m_arr;
	private String created_date_arr;
	private String detail_times;
	private String detail_init_record_date;
	private String detail_init_record_month;
	private String detail_init_create_time;
	private String detail_latest_record_date;
	private String detail_latest_record_month;
	private String detail_latest_create_time;
	private String company_count_12m_analysis;
	private String company_count_24m_analysis;
	private String company_count_6m_analysis;
	private String company_analyzed_data;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCrt_time() {
		return crt_time;
	}

	public void setCrt_time(String crt_time) {
		this.crt_time = crt_time;
	}

	public String getCrt_user() {
		return crt_user;
	}

	public void setCrt_user(String crt_user) {
		this.crt_user = crt_user;
	}

	public String getTrn_id() {
		return trn_id;
	}

	public void setTrn_id(String trn_id) {
		this.trn_id = trn_id;
	}

	public String getTrn_key() {
		return trn_key;
	}

	public void setTrn_key(String trn_key) {
		this.trn_key = trn_key;
	}

	public void setCompany_6m_arr(String company_6m_arr) {
		this.company_6m_arr = company_6m_arr;
	}

	public void setCompany_12m_arr(String company_12m_arr) {
		this.company_12m_arr = company_12m_arr;
	}

	public void setCompany_24m_arr(String company_24m_arr) {
		this.company_24m_arr = company_24m_arr;
	}

	public String getDetail_analy_id() {
		return detail_analy_id;
	}

	public void setDetail_analy_id(String detail_analy_id) {
		this.detail_analy_id = detail_analy_id;
	}

	public String getCompany_6m_arr() {
		return company_6m_arr;
	}

	public void setCompany_6m_arr(String[] company_6m_arr) {
		this.company_6m_arr = StringUtils.join(company_6m_arr, ",");

	}

	public String getCompany_12m_arr() {
		return company_12m_arr;
	}

	public void setCompany_12m_arr(String[] company_12m_arr) {
		this.company_12m_arr = StringUtils.join(company_12m_arr, ",");
	}

	public String getCompany_24m_arr() {
		return company_24m_arr;
	}

	public void setCompany_24m_arr(String[] company_24m_arr) {
		this.company_24m_arr = StringUtils.join(company_24m_arr, ",");
	}

	public String getCreated_date_arr() {
		return created_date_arr;
	}

	public void setCreated_date_arr(String created_date_arr) {
		this.created_date_arr = created_date_arr;
	}

	public String getDetail_times() {
		return detail_times;
	}

	public void setDetail_times(String detail_times) {
		this.detail_times = detail_times;
	}

	public String getDetail_init_record_date() {
		return detail_init_record_date;
	}

	public void setDetail_init_record_date(String detail_init_record_date) {
		this.detail_init_record_date = detail_init_record_date;
	}

	public String getDetail_init_record_month() {
		return detail_init_record_month;
	}

	public void setDetail_init_record_month(String detail_init_record_month) {
		this.detail_init_record_month = detail_init_record_month;
	}

	public String getDetail_init_create_time() {
		return detail_init_create_time;
	}

	public void setDetail_init_create_time(String detail_init_create_time) {
		this.detail_init_create_time = detail_init_create_time;
	}

	public String getDetail_latest_record_date() {
		return detail_latest_record_date;
	}

	public void setDetail_latest_record_date(String detail_latest_record_date) {
		this.detail_latest_record_date = detail_latest_record_date;
	}

	public String getDetail_latest_record_month() {
		return detail_latest_record_month;
	}

	public void setDetail_latest_record_month(String detail_latest_record_month) {
		this.detail_latest_record_month = detail_latest_record_month;
	}

	public String getDetail_latest_create_time() {
		return detail_latest_create_time;
	}

	public void setDetail_latest_create_time(String detail_latest_create_time) {
		this.detail_latest_create_time = detail_latest_create_time;
	}

	public String getCompany_count_12m_analysis() {
		return company_count_12m_analysis;
	}

	public void setCompany_count_12m_analysis(String company_count_12m_analysis) {
		this.company_count_12m_analysis = company_count_12m_analysis;
	}

	public String getCompany_count_24m_analysis() {
		return company_count_24m_analysis;
	}

	public void setCompany_count_24m_analysis(String company_count_24m_analysis) {
		this.company_count_24m_analysis = company_count_24m_analysis;
	}

	public String getCompany_count_6m_analysis() {
		return company_count_6m_analysis;
	}

	public void setCompany_count_6m_analysis(String company_count_6m_analysis) {
		this.company_count_6m_analysis = company_count_6m_analysis;
	}

	public String getCompany_analyzed_data() {
		return company_analyzed_data;
	}

	public void setCompany_analyzed_data(String company_analyzed_data) {
		this.company_analyzed_data = company_analyzed_data;
	}

}
