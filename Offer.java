package com.yeldi.hiber.bean;

import java.sql.Timestamp;

public class Offer {
	
	Timestamp frmdate,todate;
	double frmamt,toamount;
	
	public Offer(){}

	public Offer(Timestamp frmdate, Timestamp todate, double frmamt, double toamount) {
		super();
		this.frmdate = frmdate;
		this.todate = todate;
		this.frmamt = frmamt;
		this.toamount = toamount;
	}

	public Timestamp getFrmdate() {
		return frmdate;
	}

	public void setFrmdate(Timestamp frmdate) {
		this.frmdate = frmdate;
	}

	public Timestamp getTodate() {
		return todate;
	}

	public void setTodate(Timestamp todate) {
		this.todate = todate;
	}

	public double getFrmamt() {
		return frmamt;
	}

	public void setFrmamt(double frmamt) {
		this.frmamt = frmamt;
	}

	public double getToamount() {
		return toamount;
	}

	public void setToamount(double toamount) {
		this.toamount = toamount;
	}

	@Override
	public String toString() {
		return "Offer [frmdate=" + frmdate + ", todate=" + todate + ", frmamt=" + frmamt + ", toamount=" + toamount
				+ ", getFrmdate()=" + getFrmdate() + ", getTodate()=" + getTodate() + ", getFrmamt()=" + getFrmamt()
				+ ", getToamount()=" + getToamount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	

}
