// Using Java AWT for the GUI
import java.awt.*;
import java.awt.event.*;

public class GUI {
    private Frame startingWindow; // Frame to establish a window
    // Choice to make a pop-up menu for location options
    private Choice origin;
    private Choice destination;
    private Button search; // Button to make, well, a button

    public GUI() {
        startingWindow = new Frame("Flight Reservation");
        origin = new Choice(); 
        destination  = new Choice();
        search = new Button("Search");
        Label blankLabel = new Label(" ");

        // Adding origin options
        origin.add("CDG - Paris, France");

        // Adding destination options
        destination.add("JFK - New York City, New York");

        // GrideBagLayout used to organize elements
        startingWindow.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Organizes the elements through the coordinates
        gbc.gridx = 0;
        gbc.gridy = 0;
        startingWindow.add(new Label("Select Origin:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        startingWindow.add(origin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        startingWindow.add(new Label("Select Destination:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        startingWindow.add(destination, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        startingWindow.add(blankLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        startingWindow.add(search, gbc);

        startingWindow.setBackground(Color.getHSBColor(207f/360f, (float) 0.54, (float) 0.87)); // Sets background color of window
        startingWindow.setVisible(true);
        startingWindow.setExtendedState(Frame.MAXIMIZED_BOTH); // Sets window size to be maximum upon starting

        // Allows starting window to be closed
        startingWindow.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                startingWindow.dispose();
            }
        });

        // Brings user to the search page which displays the flights that the user can choose from
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Displays new frame (aka window) showing flights
                String originChoice = origin.getSelectedItem();
                String destinationChoice = destination.getSelectedItem();
                Frame searchingFrame = new Frame("Flight Searching");
                Label searchingLabel = new Label("Searching flights from (Origin: " + originChoice + ") to (Destination: " + destinationChoice + ")...");
                Label blankLabel = new Label(" ");
                Button reserveButton = new Button("Reserve");


                /*
                // Gets flight data from flightdata class
                String flights = flightdata.readExcelSheet();
                Label flightsList = new Label(flights);
                 */
 

                // GrideBagLayout used to organize elements
                searchingFrame.setLayout(new GridBagLayout());
                GridBagConstraints gbc_flightSearch = new GridBagConstraints();

                // Organizes the elements through the coordinates
                gbc_flightSearch.gridx = 0;
                gbc_flightSearch.gridy = 0;
                searchingFrame.add(searchingLabel, gbc_flightSearch);


                /*
                gbc_flightSearch.gridx = 0;
                gbc_flightSearch.gridy = 1;
                searchingFrame.add(flightsList, gbc_flightSearch);
                */

                gbc_flightSearch.gridx = 0;
                gbc_flightSearch.gridy = 1;
                searchingFrame.add(blankLabel, gbc_flightSearch);

                gbc_flightSearch.gridx = 0;
                gbc_flightSearch.gridy = 2;
                searchingFrame.add(reserveButton, gbc_flightSearch);

                searchingFrame.setBackground(Color.getHSBColor(207f/360f, (float) 0.54, (float) 0.87)); // Sets background color of window
                searchingFrame.setVisible(true);
                searchingFrame.setExtendedState(Frame.MAXIMIZED_BOTH); // Maxizes window screen size

                // Allows searchingFrame to be closed
                searchingFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        searchingFrame.dispose();
                    }
                });

                reserveButton.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                        // Displays another window that brings user to the reservation screen
                        Frame reservationFrame = new Frame("Flight Reserving");
                        Button completeButton = new Button("Complete");
                        Label blankLabel = new Label(" ");
                        Label fnLabel, lnLabel, emailLabel, dobLabel, passportLabel;
                        TextField firstName, lastName, email, dob, passportNum;

                        fnLabel = new Label("First Name: ");
                        lnLabel = new Label("Last Name: ");
                        emailLabel = new Label("Email: ");
                        dobLabel = new Label("Date of Birth: ");
                        passportLabel = new Label("Passport #: ");

                        firstName = new TextField("", 15);
                        lastName = new TextField("", 15);
                        email = new TextField("", 15);
                        dob = new TextField("", 15);
                        passportNum = new TextField("", 15);

                        // GrideBagLayout used to organize elements
                        reservationFrame.setLayout(new GridBagLayout());
                        GridBagConstraints gbc_flightReserve = new GridBagConstraints();

                        // Organizes the elements through the coordinates
                        gbc_flightReserve.gridx = 0;
                        gbc_flightReserve.gridy = 0;
                        reservationFrame.add(fnLabel, gbc_flightReserve);

                        gbc_flightReserve.gridx = 1;
                        gbc_flightReserve.gridy = 0;
                        reservationFrame.add(firstName, gbc_flightReserve);

                        gbc_flightReserve.gridx = 0;
                        gbc_flightReserve.gridy = 1;
                        reservationFrame.add(lnLabel, gbc_flightReserve);

                        gbc_flightReserve.gridx = 1;
                        gbc_flightReserve.gridy = 1;
                        reservationFrame.add(lastName, gbc_flightReserve);

                        gbc_flightReserve.gridx = 0;
                        gbc_flightReserve.gridy = 2;
                        reservationFrame.add(emailLabel, gbc_flightReserve);

                        gbc_flightReserve.gridx = 1;
                        gbc_flightReserve.gridy = 2;
                        reservationFrame.add(email, gbc_flightReserve);

                        gbc_flightReserve.gridx = 0;
                        gbc_flightReserve.gridy = 3;
                        reservationFrame.add(dobLabel, gbc_flightReserve);

                        gbc_flightReserve.gridx = 1;
                        gbc_flightReserve.gridy = 3;
                        reservationFrame.add(dob, gbc_flightReserve);

                        gbc_flightReserve.gridx = 0;
                        gbc_flightReserve.gridy = 4;
                        reservationFrame.add(passportLabel, gbc_flightReserve);

                        gbc_flightReserve.gridx = 1;
                        gbc_flightReserve.gridy = 4;
                        reservationFrame.add(passportNum, gbc_flightReserve);

                        gbc_flightReserve.gridx = 0;
                        gbc_flightReserve.gridy = 5;
                        reservationFrame.add(blankLabel, gbc_flightReserve);

                        gbc_flightReserve.gridx = 1;
                        gbc_flightReserve.gridy = 6;
                        reservationFrame.add(completeButton, gbc_flightReserve);

                        reservationFrame.setBackground(Color.getHSBColor(207f/360f, (float) 0.54, (float) 0.87)); // Sets background color of window
                        reservationFrame.setVisible(true);
                        reservationFrame.setExtendedState(Frame.MAXIMIZED_BOTH); // Maxizes window screen size

                        // Allows reservationFrame to be closed
                        reservationFrame.addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                reservationFrame.dispose();
                            }
                        });
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
