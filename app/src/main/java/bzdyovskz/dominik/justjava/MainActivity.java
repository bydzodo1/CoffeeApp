package bzdyovskz.dominik.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    private int quantity = 0;
    private double coffeePrice = 7.5d;
    private boolean isOrdered = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increment(View view){
        if (isOrdered) return;
        this.quantity++;
        display(quantity);
        displayPrice(quantity * coffeePrice);
    }

    public void decrement(View view){
        if (isOrdered) return;
        if (quantity > 0) this.quantity--;
        display(quantity);
        displayPrice(quantity * coffeePrice);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        if (isOrdered) return;
        isOrdered = true;
        String text = "Thank you for your order. You ordered " + quantity + " coffee for $" + (quantity * coffeePrice) + ".";

        quantity = 0;
        display(0);
        displayPrice(0);
        TextView thankTextView = (TextView) findViewById(
                R.id.thanks_text_view);
        thankTextView.setText(text);
        Button newOrderButton = (Button) findViewById(R.id.new_order_button);
        newOrderButton.setVisibility(View.VISIBLE);
        Button submitOrderButton = (Button) findViewById(R.id.submit_order_button);
        submitOrderButton.setVisibility(View.INVISIBLE);
    }
    public void newOrder(View view) {
        isOrdered = false;
        quantity = 0;
        display(0);
        displayPrice(0);
        TextView thankTextView = (TextView) findViewById(
                R.id.thanks_text_view);
        thankTextView.setText("");
        Button newOrderButton = (Button) findViewById(R.id.new_order_button);
        newOrderButton.setVisibility(View.INVISIBLE);
        Button submitOrderButton = (Button) findViewById(R.id.submit_order_button);
        submitOrderButton.setVisibility(View.VISIBLE);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}