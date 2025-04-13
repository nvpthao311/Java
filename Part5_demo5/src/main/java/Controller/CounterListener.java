package Controller;

import View.CounterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterListener implements ActionListener {
    CounterView ctv;

    public CounterListener (CounterView ctv){
        this.ctv = ctv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        if (src.equals("UP")){
            this.ctv.increment();
        }else if (src.equals("DOWN")){
            this.ctv.decrement();
        }
    }
}
