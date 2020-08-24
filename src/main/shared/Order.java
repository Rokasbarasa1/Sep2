package main.shared;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;

public class Order implements Serializable, Printable {
    private int ID;
    private ArrayList<Item> items;
    private boolean finished;

    public Order(int ID, ArrayList<Item> items) {
        this.ID = ID;
        this.items = items;
        this.finished = false;
    }

    public int getID() {
        return ID;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    //For table, it is used, dont delete
    public String getItems() {
        String itemsString = "";
        for (int i = 0; i < items.size(); i++) {
            itemsString += items.get(i).getName()+ ", ";
        }
        return itemsString;
    }

    public String getItemsForPrinting() {
        String itemsString = "Id of order: " + ID + "\n";
        for (int i = 0; i < items.size(); i++) {
            itemsString += items.get(i).toString() + "\n";
        }
        return itemsString;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        // Should only have one page, and page # is zero-based.
        if (page > 0)
        {
            return NO_SUCH_PAGE;
        }

        // Adding the "Imageable" to the x and y puts the margins on the page.
        // To make it safe for printing.
        Graphics2D g2d = (Graphics2D)g;
        int x = (int) pf.getImageableX();
        int y = (int) pf.getImageableY();
        g2d.translate(x, y);

        // Calculate the line height
        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        BufferedReader br = new BufferedReader(new StringReader(getItemsForPrinting()));

        // Draw the page:
        try
        {
            String line;
            // Just a safety net in case no margin was added.
            x += 50;
            y += 50;
            while ((line = br.readLine()) != null)
            {
                y += lineHeight;
                g2d.drawString(line, x, y);
            }
        }
        catch (IOException e)
        {
            //
        }

        return PAGE_EXISTS;
    }
}
