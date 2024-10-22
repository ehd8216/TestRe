package com.kh.test.ct;

import java.io.IOException;

public class codeTest {
	
	public static void main(String[] args) throws IOException {
		String[] commands = new String[2];
		commands[0] = "prev";
		commands[1] = "next";
//		commands[2] = "prev";
		
		String answer = solution("10:00", "00:03", "00:00", "00:05", commands);
		System.out.println(answer);
		
	}
	
	public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoTime = changeNum(video_len);
        int posTime = changeNum(pos);
        int startTime = changeNum(op_start);
        int endTime = changeNum(op_end);
        if(posTime >= startTime && posTime < endTime) {
        	posTime = endTime;
        }
        for(String str : commands) {
        	if(posTime >= startTime && posTime < endTime) {
            	posTime = endTime;
            }
        	if(str.equals("prev")) {
        		posTime -= 10;
        		if(posTime >= startTime && posTime < endTime) {
                	posTime = endTime;
                }
        		if(posTime < 0) {
        			posTime = 0;
        		}
        	}else {
        		posTime += 10;
        		if(posTime >= startTime && posTime < endTime) {
                	posTime = endTime;
                }
        		if(posTime > videoTime) {
        			posTime = videoTime;
        		}
        	}
        	System.out.println(posTime);
        }
        if(posTime >= startTime && posTime < endTime) {
        	posTime = endTime;
        }
        String min = posTime / 60 + "";
        String sec = posTime % 60 + "";
        if(min.length() == 1) {
        	min = "0" + min;
        }
        if(sec.length() == 1) {
        	sec = "0" + sec;
        }
        
        return min + ":" + sec;
    }
	
	public static int changeNum(String time) {
		String[] timeArr = time.split(":");
        int result = (Integer.valueOf(timeArr[0])*60) + (Integer.valueOf(timeArr[1]));
        return result;
	}
	

}
