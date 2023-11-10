import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

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
        originChoice.add("CDG - Paris, France");
        originChoice.add("DAL - Dallas, USA");
        originChoice.add("DXB - Dubai, UAE");
        originChoice.add("FRA - Frankfurt, Germany");
        originChoice.add("JFK - New York City, USA");
        originChoice.add("LAX - Los Angeles, USA");
        originChoice.add("LHR - London, UK");
        originChoice.add("MIA - Miami, USA");
        originChoice.add("ORD - Chicago, USA");
        originChoice.add("SIN - Changi, Singapore");
        originChoice.add("SYD - Sydney, Australia");
        destinationChoice.add("New York City, New York");
        destinationChoice.add("Chicago, Illinois");
        destinationChoice.add("Miami, Florida");

        //GridBagLayout used to organize GUI elements
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
                Frame searchingFrame = new Frame("Flight Search");
                Label searchingLabel = new Label("Searching for flights from " + origin + " to " + destination);
                searchingLabel.setAlignment(Label.CENTER); // Aligns text to center
                searchingFrame.add(searchingLabel);
                searchingFrame.setBounds(0, 0, 200, 100);
                searchingFrame.setVisible(true);
                searchingFrame.setExtendedState(searchingFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH); // Opens up frame to maximize size

                // Allows searchingFrame to be closed.
                searchingFrame.addWindowListener(new WindowAdapter () {
                    public void windowClosing(WindowEvent e) {
                        searchingFrame.dispose();
                    }
                });
            }
        });

        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH); // Opens up frame to maximize size

        // Allows main frame be closed.
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
