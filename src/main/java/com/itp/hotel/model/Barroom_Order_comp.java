//package com.itp.hotel.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Embeddable;
//
//@Embeddable
//
//public class Barroom_Order_comp implements Serializable{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private Long bar_Order_Id;
//	private Long bev_Id;
//	public Long getBar_Order_Id() {
//		return bar_Order_Id;
//	}
//	public void setBar_Order_Id(Long bar_Order_Id) {
//		this.bar_Order_Id = bar_Order_Id;
//	}
//	public Long getBev_Id() {
//		return bev_Id;
//	}
//	public void setBev_Id(Long bev_Id) {
//		this.bev_Id = bev_Id;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((bar_Order_Id == null) ? 0 : bar_Order_Id.hashCode());
//		result = prime * result + ((bev_Id == null) ? 0 : bev_Id.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Barroom_Order_comp other = (Barroom_Order_comp) obj;
//		if (bar_Order_Id == null) {
//			if (other.bar_Order_Id != null)
//				return false;
//		} else if (!bar_Order_Id.equals(other.bar_Order_Id))
//			return false;
//		if (bev_Id == null) {
//			if (other.bev_Id != null)
//				return false;
//		} else if (!bev_Id.equals(other.bev_Id))
//			return false;
//		return true;
//	}
//	
//	
//	
//	
//	
//}
