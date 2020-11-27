package com.huaxia.plaze.modules.jianbing.domain;

/**
 * 第三方 & 51易达金
 * 
 * @author liyanan
 *
 */
public class JianBingComAnalData {

	private String uuid;
	private String crt_time;
	private String crt_user;
	private String trn_id;
	private String trn_key; // 交易关联键
	private String company;
	private String cont_last_times;
	private String back_cont_last_times;
	private String cont_max_times;
	private String back_cont_max_times;
	private String sum_times;
	private String back_sum_times;
	private String start_month;
	private String end_month;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCont_last_times() {
		return cont_last_times;
	}

	public void setCont_last_times(String cont_last_times) {
		this.cont_last_times = cont_last_times;
	}

	public String getBack_cont_last_times() {
		return back_cont_last_times;
	}

	public void setBack_cont_last_times(String back_cont_last_times) {
		this.back_cont_last_times = back_cont_last_times;
	}

	public String getCont_max_times() {
		return cont_max_times;
	}

	public void setCont_max_times(String cont_max_times) {
		this.cont_max_times = cont_max_times;
	}

	public String getBack_cont_max_times() {
		return back_cont_max_times;
	}

	public void setBack_cont_max_times(String back_cont_max_times) {
		this.back_cont_max_times = back_cont_max_times;
	}

	public String getSum_times() {
		return sum_times;
	}

	public void setSum_times(String sum_times) {
		this.sum_times = sum_times;
	}

	public String getBack_sum_times() {
		return back_sum_times;
	}

	public void setBack_sum_times(String back_sum_times) {
		this.back_sum_times = back_sum_times;
	}

	public String getStart_month() {
		return start_month;
	}

	public void setStart_month(String start_month) {
		this.start_month = start_month;
	}

	public String getEnd_month() {
		return end_month;
	}

	public void setEnd_month(String end_month) {
		this.end_month = end_month;
	}

}
