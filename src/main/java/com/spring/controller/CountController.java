package com.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.pojo.PCount;
import com.spring.srvice.PCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
@Controller
public class CountController {
	int count=0;
	int count1 =1;
	int count2 =1;
	int count3 =1;
	int count4 =1;
	int count5 =1;
	int count6 =1;
	int count7 =1;
    @Autowired
    private PCountService pCountService;

    @RequestMapping(value="/value.do",method= RequestMethod.GET)
    public @ResponseBody Map jd(HttpServletRequest request, Model model){
    	//拿到请求的值
        PCount jd = pCountService.selectCount("JD");
        PCount other = pCountService.selectCount("Other");
        PCount tm = pCountService.selectCount("TM");
        PCount tb = pCountService.selectCount("TB");
        PCount wp = pCountService.selectCount("WP");
      //组合成json对象{count1:{jd},}
        Map<String,List<Integer>> map=new HashMap<String,List<Integer>>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(other.getCount1());list1.add(other.getCount2());list1.add(other.getCount3());list1.add(other.getCount4());list1.add(other.getCount5());list1.add(other.getCount6());list1.add(other.getCount7());
        List<Integer> list2=new ArrayList<>();
        list2.add(wp.getCount1());list2.add(wp.getCount2());list2.add(wp.getCount3());list2.add(wp.getCount4());list2.add(wp.getCount5());list2.add(wp.getCount6());list2.add(wp.getCount7());
        List<Integer> list3=new ArrayList<>();
        list3.add(jd.getCount1());list3.add(jd.getCount2());list3.add(jd.getCount3());list3.add(jd.getCount4());list3.add(jd.getCount5());list3.add(jd.getCount6());list3.add(jd.getCount7());
        List<Integer> list4=new ArrayList<>();
        list4.add(tb.getCount1());list4.add(tb.getCount2());list4.add(tb.getCount3());list4.add(tb.getCount4());list4.add(tb.getCount5());list4.add(tb.getCount6());list4.add(tb.getCount7());
        List<Integer> list5=new ArrayList<>();
        list5.add(tm.getCount1());list5.add(tm.getCount2());list5.add(tm.getCount3());list5.add(tm.getCount4());list5.add(tm.getCount5());list5.add(tm.getCount6());list5.add(tm.getCount7());
        map.put("count1", list1);
        map.put("count2", list2);
        map.put("count3", list3);
        map.put("count4", list4);
        map.put("count5", list5);
//        Object json = JSONObject.toJSON(map);
        
        return map;
    }
    
   
    
    
    //更新mysql数据里的东西
    @RequestMapping(value="update.do",method=RequestMethod.GET)
    public void update_count(HttpServletRequest request,Model model) {
    	while(true) {
    		/**
    		 * 进行49次随机数拿取 。进行每个数据进行分化。
    		 */
    		count+=1;
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
	    	PCount pcount =  new PCount("JD", count1+=getRandom(), count2+=getRandom(), count3+=getRandom(), count4+=getRandom(), count5+=getRandom(), count6+=getRandom(), count7+=getRandom());
	    	pCountService.update(pcount);
	    	PCount pcount1 =  new PCount("Other", count1+=getRandom(), count2+=getRandom(), count3+=getRandom(), count4+=getRandom(), count5+=getRandom(), count6+=getRandom(), count7+=getRandom());
	    	pCountService.update(pcount1);
	    	PCount pcount2 =  new PCount("TM", count1+=getRandom(), count2+=getRandom(), count3+=getRandom(), count4+=getRandom(), count5+=getRandom(), count6+=getRandom(), count7+=getRandom());
	    	pCountService.update(pcount2);
	    	PCount pcount3 =  new PCount("TB", count1+=getRandom(), count2+=getRandom(), count3+=getRandom(), count4+=getRandom(), count5+=getRandom(), count6+=getRandom(), count7+=getRandom());
	    	pCountService.update(pcount3);
	    	PCount pcount4 =  new PCount("WP",count1+=getRandom(), count2+=getRandom(), count3+=getRandom(), count4+=getRandom(), count5+=getRandom(), count6+=getRandom(), count7+=getRandom());
	    	pCountService.update(pcount4);
	    	System.out.println("更新一次："+count);
    	}
    	
    }
    
    public static int getRandom() {
    	return (int)(Math.random()*1000)+1;
    }
    //进行查询

    
    
    
}
