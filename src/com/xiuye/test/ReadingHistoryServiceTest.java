package com.xiuye.test;

import java.util.List;

import com.xiuye.beans.ReadingHistoryBook;
import com.xiuye.orm.User;
import com.xiuye.service.ReadingHistoryService;
import com.xiuye.util.SpringUtil;

public class ReadingHistoryServiceTest {

	public static void main(String[] args) {
		
		ReadingHistoryService service = SpringUtil.getBean(ReadingHistoryService.class);
		User user = new User();
		user.setUserid("12101010423");
		List<ReadingHistoryBook> rhBooks = service.getUserReadingHistoryBooks(user);
		int i=0;
		for(ReadingHistoryBook rhb : rhBooks){
			//System.out.println(rhb.getBook().getBookid());
			i++;
			if(rhb.getBook().getBookid() == null){
				System.out.println(i);
			}
			if(rhb.getBook().getBookid() != null && rhb.getBook().getBookid().isEmpty()){
				System.out.println(i);
			}
		}
		System.out.println("over");
	}
	
}
