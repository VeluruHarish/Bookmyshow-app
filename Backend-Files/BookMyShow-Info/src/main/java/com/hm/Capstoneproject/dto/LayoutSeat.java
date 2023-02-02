
package com.hm.Capstoneproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayoutSeat {
 private int id;
 private int seatNo;
 private boolean checked;
 private boolean booked;
 
}
