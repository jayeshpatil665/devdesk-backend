package com.devdesk.request;

public class NewTask {

	private int tId;
	
	private String tName;
	private String tEmail;
	private String tInfo;
	private String tSolution;
	
	private String tClient;
	private int tPriority;
	private int tPool;
	
	private String tReportDate;
	private String tResolutionDate;
	
	private String tTags;
	private int tStatus;
	
	private String tPickedBy="";

	public NewTask() {
		super();
	}

	public NewTask(int tId, String tName, String tEmail, String tInfo, String tSolution, String tClient, int tPriority,
			int tPool, String tReportDate, String tResolutionDate, String tTags, int tStatus, String tPickedBy) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tEmail = tEmail;
		this.tInfo = tInfo;
		this.tSolution = tSolution;
		this.tClient = tClient;
		this.tPriority = tPriority;
		this.tPool = tPool;
		this.tReportDate = tReportDate;
		this.tResolutionDate = tResolutionDate;
		this.tTags = tTags;
		this.tStatus = tStatus;
		this.tPickedBy = tPickedBy;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String gettInfo() {
		return tInfo;
	}

	public void settInfo(String tInfo) {
		this.tInfo = tInfo;
	}

	public String gettSolution() {
		return tSolution;
	}

	public void settSolution(String tSolution) {
		this.tSolution = tSolution;
	}

	public String gettClient() {
		return tClient;
	}

	public void settClient(String tClient) {
		this.tClient = tClient;
	}

	public int gettPriority() {
		return tPriority;
	}

	public void settPriority(int tPriority) {
		this.tPriority = tPriority;
	}

	public int gettPool() {
		return tPool;
	}

	public void settPool(int tPool) {
		this.tPool = tPool;
	}

	public String gettReportDate() {
		return tReportDate;
	}

	public void settReportDate(String tReportDate) {
		this.tReportDate = tReportDate;
	}

	public String gettResolutionDate() {
		return tResolutionDate;
	}

	public void settResolutionDate(String tResolutionDate) {
		this.tResolutionDate = tResolutionDate;
	}

	public String gettTags() {
		return tTags;
	}

	public void settTags(String tTags) {
		this.tTags = tTags;
	}

	public int gettStatus() {
		return tStatus;
	}

	public void settStatus(int tStatus) {
		this.tStatus = tStatus;
	}

	public String gettPickedBy() {
		return tPickedBy;
	}

	public void settPickedBy(String tPickedBy) {
		this.tPickedBy = tPickedBy;
	}

	@Override
	public String toString() {
		return "NewTask [tId=" + tId + ", tName=" + tName + ", tEmail=" + tEmail + ", tInfo=" + tInfo + ", tSolution="
				+ tSolution + ", tClient=" + tClient + ", tPriority=" + tPriority + ", tPool=" + tPool
				+ ", tReportDate=" + tReportDate + ", tResolutionDate=" + tResolutionDate + ", tTags=" + tTags
				+ ", tStatus=" + tStatus + ", tPickedBy=" + tPickedBy + "]";
	}
	
}
