package com.example.decimalconverter;

import java.util.Scanner;

public class DecimalConverter {

	public static void main( String args[] ) {

		Scanner scan = new Scanner( System.in );

		System.out.print( "Enter b/h/d for binary, hexadecimal, or decimal conversions: " );

		String cat = scan.nextLine( );
		char category = cat.toLowerCase().charAt( 0 );

		if( category == 'b' ) { // input = binary

			long inputBit;
	
			System.out.print( "\n" + "Enter the number to convert in binary: " );
			inputBit = scan.nextInt( );
			while( inputBit != -1 ) {
	
				System.out.print( "Decimal = " + getDecimal( inputBit ) + "\n" );
				System.out.print( "Hexadecimal= " + getHexadecimal( inputBit ) + "\n" );

				System.out.print( "\n" + "Enter the number to convert in binary: " );
				inputBit = scan.nextInt( );
			}
		} else if( category == 'h' ) { // input = hexadecimal

			String inputHex = "";

			System.out.print( "Enter the number to convert in hexadecimal: " );
			inputHex = scan.nextLine( );
			while( !inputHex.equals( "-1" ) ) {
	
				System.out.print( "Bit= " + getBit( inputHex ) + "\n" );
				System.out.print( "Decimal = " + getDecimal( inputHex ) + "\n" );

				System.out.print( "Enter the number to convert in hexadecimal: " );
				inputHex = scan.nextLine( );
			}
			
		} else if( category == 'd' ) { // input = decimal

			int inputDec;

			System.out.print( "\n" + "Enter the number to convert in decimal: " );
			inputDec = scan.nextInt( );
			while( inputDec != -1 ) {
	
				System.out.print( "Bit= " + getBit( inputDec ) + "\n" );
				System.out.print( "Hexadecimal = " + getHexadecimal( inputDec ) + "\n" );

				System.out.print( "\n" + "Enter the number to convert in decimal: " );
				inputDec = scan.nextInt( );
			}
		}

	}

	// decimals
	public static int getDecimal( long bit ) {
		
        int decimalNumber = 0, currentPower = 0;
 
        while( bit > 0 ) {

            decimalNumber += Math.pow(2, currentPower++) * (bit % 10);
            bit /= 10;
        }
		
        return decimalNumber;
    }

	public static int getDecimal( String hexadecimal ) {
		return Integer.parseInt( hexadecimal, 16 );	
	}


	// bits
	public static long getBit( int decimal ) {
		return Long.parseLong( Long.toBinaryString( decimal ) );
	}

	public static long getBit( String hexadecimal ) {
		return getBit( getDecimal( hexadecimal ) );
	}


	// hexadecimals
    public static String getHexadecimal( long bit ) {
		return getHexadecimal( getDecimal( bit ) );
    }

    public static String getHexadecimal( int decimal ) {
		return Integer.toHexString( decimal ).toUpperCase( );
    }

}