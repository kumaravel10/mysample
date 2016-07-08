package Mypractise;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.yeldi.hiber.bean.Offer;

public class Offermain {
	
	public static void main(String args[])
	{
		
		
    double frmamt=1000.00;
    double toamt=2000.00;
    boolean stat=false;
    Timestamp fdate=getdatetime("2016-03-01 00:00:00");
    Timestamp tdate=getdatetime("2016-03-05 23:59:59");
	
	List<Offer> list=new ArrayList<Offer>();
	list.add(new Offer(getdatetime("2016-03-01 00:00:00"), getdatetime("2016-03-05 23:59:59"), 1000.00, 2000.00));
	list.add(new Offer(getdatetime("2016-03-06 00:00:00"), getdatetime("2016-03-08 23:59:59"), 500.00, 999.00));
	
	
	Iterator<Offer> itr=list.iterator();
	while(itr.hasNext())
	{
		Offer of=itr.next();
		if(fdate.before(of.getTodate()))
		{
			
			if(frmamt<of.getFrmamt()&&toamt<of.getFrmamt())
			{
				System.out.println("offer applicable****");
				stat=true;
			}
			else if(frmamt>of.getToamount()&&toamt>of.getToamount())
			{
				System.out.println("offer applicable#####");
				stat=true;
			}
			else
			{
				System.out.println("offer not applicable&&&&&&&");
				stat=false;
			}
			if(stat==false)
			{
				break;
			}
				
		}
		
		if(fdate.after(of.getTodate()))
		{
			System.out.println("offer applicable^^^^^^^^");
			stat=true;
		}
	}
	if(stat==true)
	{
		System.out.println("offer added");
	}
	if(stat==false)
	{
		System.out.println("offer not added");
	}
	
	
	
	}
	
	static Timestamp getdatetime(String str)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(
	            "yyyy-MM-dd hh:mm:ss");
		Timestamp timestamp=null;

	    Date parsedTimeStamp;
		try {
			parsedTimeStamp = dateFormat.parse(str);
			timestamp = new Timestamp(parsedTimeStamp.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
	    return timestamp;
	}
	
	
}
