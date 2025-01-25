package com.devdesk.response;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class Task {

	private int tId;
	
	private int tPool;
	private String tName;
	private String tClient;
	private String tInfo;
	private String tEmail;
	
	private Map<String, Integer> tPickedBy;
	
	private Date tReportDate;
	private Date tResolutionDate;
	
	private String tTag[];
	
	private int tPriority;
	private int tStatus;
	private String tSolution;
	
	public Task() {
		super();
	}

	public Task(int tId, int tPool, String tName, String tClient, String tInfo, String tEmail,
			Map<String, Integer> tPickedBy, Date tReportDate, Date tResolutionDate, String[] tTag, int tPriority,
			int tStatus, String tSolution) {
		super();
		this.tId = tId;
		this.tPool = tPool;
		this.tName = tName;
		this.tClient = tClient;
		this.tInfo = tInfo;
		this.tEmail = tEmail;
		this.tPickedBy = tPickedBy;
		this.tReportDate = tReportDate;
		this.tResolutionDate = tResolutionDate;
		this.tTag = tTag;
		this.tPriority = tPriority;
		this.tStatus = tStatus;
		this.tSolution = tSolution;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int gettPool() {
		return tPool;
	}

	public void settPool(int tPool) {
		this.tPool = tPool;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettClient() {
		return tClient;
	}

	public void settClient(String tClient) {
		this.tClient = tClient;
	}

	public String gettInfo() {
		return tInfo;
	}

	public void settInfo(String tInfo) {
		this.tInfo = tInfo;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public Map<String, Integer> gettPickedBy() {
		return tPickedBy;
	}

	public void settPickedBy(Map<String, Integer> tPickedBy) {
		this.tPickedBy = tPickedBy;
	}

	public Date gettReportDate() {
		return tReportDate;
	}

	public void settReportDate(Date tReportDate) {
		this.tReportDate = tReportDate;
	}

	public Date gettResolutionDate() {
		return tResolutionDate;
	}

	public void settResolutionDate(Date tResolutionDate) {
		this.tResolutionDate = tResolutionDate;
	}

	public String[] gettTag() {
		return tTag;
	}

	public void settTag(String[] tTag) {
		this.tTag = tTag;
	}

	public int gettPriority() {
		return tPriority;
	}

	public void settPriority(int tPriority) {
		this.tPriority = tPriority;
	}

	public int gettStatus() {
		return tStatus;
	}

	public void settStatus(int tStatus) {
		this.tStatus = tStatus;
	}

	public String gettSolution() {
		return tSolution;
	}

	public void settSolution(String tSolution) {
		this.tSolution = tSolution;
	}

	@Override
	public String toString() {
		return "Task [tId=" + tId + ", tPool=" + tPool + ", tName=" + tName + ", tClient=" + tClient + ", tInfo="
				+ tInfo + ", tEmail=" + tEmail + ", tPickedBy=" + tPickedBy + ", tReportDate=" + tReportDate
				+ ", tResolutionDate=" + tResolutionDate + ", tTag=" + Arrays.toString(tTag) + ", tPriority="
				+ tPriority + ", tStatus=" + tStatus + ", tSolution=" + tSolution + "]";
	}
	
}
