import java.awt.*;
import java.awt.event.*;

public class FlightFinderApp {
    private Frame frame;
    private Choice originChoice;
    private Choice destinationChoice;
    private Button searchButton;

    public FlightFinderApp() {
        frame = new Frame("Flight Finder");
        originChoice = new Choice();
        destinationChoice = new Choice();
        searchButton = new Button("Search");

        // Adding destinations to the dropdowns
        originChoice.add("Austin, Texas");
        originChoice.add("Los Angeles, California");
        originChoice.add("Portland, Oregon");
        destinationChoice.add("New York City, New York");
        destinationChoice.add("Chicago, Illinois");
        destinationChoice.add("Miami, Florida");

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new Label("Select Origin:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(originChoice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new Label("Select Destination:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(destinationChoice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(searchButton, gbc);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // PRINTS TO CONSOLE WHAT FLIGHT IS BEING SEARCHED
                String origin = originChoice.getSelectedItem();
                String destination = destinationChoice.getSelectedItem();
                System.out.println("Searching for flights from " + origin + " to " + destination);
                // Perform flight search logic here

                // Displays new frame (aka window) showing flights.
                Frame searchingFrame = new Frame("Searching for flights from " + origin + " to " + destination);
                Label searchingLabel = new Label("Searching for flights from " + origin + " to " + destination);
                searchingFrame.add(searchingLabel);
                searchingFrame.setBounds(0, 0, 200, 100);
                searchingFrame.setVisible(true);

                searchingFrame.addWindowListener(new WindowAdapter () {
                    public void windowClosing(WindowEvent e) {
                        searchingFrame.dispose();
                    }
                });
            }
        });

        frame.setSize(300, 200);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new FlightFinderApp();
    }
}
