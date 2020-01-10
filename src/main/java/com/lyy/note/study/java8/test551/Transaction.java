package com.lyy.note.study.java8.test551;

public class Transaction {
	private final Trader trader;
	
	private final int year;
	
	/**交易额*/
	private final int value;

	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + ", getTrader()=" + getTrader()
				+ ", getYear()=" + getYear() + ", getValue()=" + getValue() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
