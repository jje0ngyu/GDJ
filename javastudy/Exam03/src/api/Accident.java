package api;

import lombok.Builder;

@Builder
		
public class Accident {
	
	 private String occrrncDt;     // 발생월일시 (2019011622)
     private String occrrncDayCd;  // 발생요일코드 (4)
     private String dthDnvCnt;     // 사망자수 (0)
     private String injpsnCnt;	   // 부상자수 (1)
     
	@Override
	public String toString() {
		
		return "발생일자 " + occrrncDt + "  " + occrrncDayCd + ", 사망자수" + dthDnvCnt
				+ "명, 부상자수" + injpsnCnt + "명";
	}
     
}


