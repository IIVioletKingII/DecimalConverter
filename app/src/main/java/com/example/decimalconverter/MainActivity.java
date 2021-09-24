package com.example.decimalconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.decimalconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;

	EditText editBinary;
	EditText editDecimal;
	EditText editHexadecimal;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {

		super.onCreate( savedInstanceState );
		binding = ActivityMainBinding.inflate( getLayoutInflater( ) );
		setContentView( binding.getRoot( ) );

		editBinary = binding.binaryTextInput;
		editDecimal = binding.decimalTextInput;
		editHexadecimal = binding.hexadecimalTextInput;

		editBinary.setText( "0" );
		editDecimal.setText( "0" );
		editHexadecimal.setText( "0" );
	}

	public void onBinClick( View view ) {
		long binaryNum = Long.parseLong( editBinary.getText( ).toString( ) );
		convertBin( binaryNum );
	}

	public void onDecClick( View view ) {
		int decimalNum = Integer.parseInt( editDecimal.getText( ).toString( ) );
		convertDec( decimalNum );
	}

	public void onHexClick( View view ) {
		String hexadecimalNum = editHexadecimal.getText( ).toString( );
		convertHex( hexadecimalNum );
	}

	public void convertBin( long binaryNum ) {
		// already have the binary number
		editDecimal.setText( "" + DecimalConverter.getDecimal( binaryNum ) );
		editHexadecimal.setText( "" + DecimalConverter.getHexadecimal( binaryNum ) );
	}

	public void convertDec( int decimalNum ) {
		editBinary.setText( "" + DecimalConverter.getBit( decimalNum ) );
		// already have the decimal number
		editHexadecimal.setText( "" + DecimalConverter.getHexadecimal( decimalNum ) );
	}

	public void convertHex( String hexadecimalNum ) {
		editBinary.setText( "" + DecimalConverter.getBit( hexadecimalNum ) );
		editDecimal.setText( "" + DecimalConverter.getDecimal( hexadecimalNum ) );
		// already have the hexadecimal number
	}



}
