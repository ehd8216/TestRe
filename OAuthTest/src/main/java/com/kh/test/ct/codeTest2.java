package com.kh.test.ct;

public class codeTest2 {

	public static void main(String[] args) {
		int answer = 0;
		int[] wallet = new int[2];
		int[] bill = new int[2];
		wallet[0] = 50;
		wallet[1] = 50;
		bill[0] = 100;
		bill[1] = 241;
		
		int ws = 0;
		int wl = 0;
		int bs = 0;
		int bl = 0;
		if(wallet[0] > wallet[1]) {
			wl = wallet[0];
			ws = wallet[1];
		}else {
			wl = wallet[1];
			ws = wallet[0];
		}
		
		if(bill[0] > bill[1]) {
			bs = bill[1];
			bl = bill[0];
		}else {
			bs = bill[0];
			bl = bill[1];
		}
		//    17  15     13   30
		while(bs > ws || bl > wl) {
			if(bs > bl) {
				bs = bs/2;
			}else {
				bl = bl/2;
			}
			
			if(bs>bl) {
				int a = bs;
				bs = bl;
				bl = a;
			}
			answer++;
		}
		System.out.println(answer);
	}

}
