/*
"6. Create a class and demonstrate proper encapsulation techniques
the class will be called Printer
It will simulate a real Computer printer
It should have fields for toner level, number of pages printed, and also
whether its a duplex printer (capable of printing on both sides of the paper).
Add methods to fill up the toner (up to a maximum of 100%), another method to
simulate printing a page(which should increase the number of pages printed).
Decide on the scope, whether to use constructors, and anything else you think is needed."
 */
public class Lesson56Printer {
    public static void main(String[] args) {
        myPrinter myRealPrinter = new myPrinter("Fony", "T1000", true, false);
        myRealPrinter.printDoJob(70, true, true);
        System.out.println(myRealPrinter.getManufacturer() + " Printer condition " + myRealPrinter.getPrinterCondition());
        System.out.println("Printed page " + myRealPrinter.getPrintedPages());

        myPrinter myRealPrinterSecond = new myPrinter("Famfung", "S1000", false, true);
        myRealPrinterSecond.printDoJob(17, true, true);
        System.out.println(myRealPrinterSecond.getManufacturer() + " Printer condition " + myRealPrinterSecond.getPrinterCondition());
        System.out.println("Printed page " + myRealPrinterSecond.getPrintedPages());

        myRealPrinterSecond.fixPrinter();
    }

    public static class myPrinter {
        private static double tonerLevelBlack = 100;
        private static double tonerLevelMagenta = 100;
        private static double tonerLevelYellow = 100;
        private static double tonerLevelBlue = 100;
        private static int printedPages;
        private static double printerCondition = 100;
        private String manufacturer;
        private String model;
        private boolean isColor;
        private boolean isDuplex;

        myPrinter(java.lang.String manufacturer, java.lang.String model, boolean isColor, boolean isDuplex) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.isColor = isColor;
            this.isDuplex = isDuplex;
        }

        String getManufacturer() {
            return manufacturer;
        }

        public String getModel() {
            return model;
        }

        public boolean getColor() {
            return isColor;
        }

        public boolean isDuplex() {
            return isDuplex;
        }

        private double getTonerLevelBlack() {
            return tonerLevelBlack;
        }

        void setTonerLevelBlack(double printedPages) {
            tonerLevelBlack -= printedPages / 100;
        }

        private double getTonerLevelMagenta() {
            return tonerLevelMagenta;
        }

        void setTonerLevelMagenta(double printedPages) {
            tonerLevelMagenta -= printedPages / 100;
        }

        private double getTonerLevelYellow() {
            return tonerLevelYellow;
        }

        void setTonerLevelYellow(double printedPages) {
            tonerLevelYellow -= printedPages / 100;
        }

        private double getTonerLevelBlue() {
            return tonerLevelBlue;
        }

        void setTonerLevelBlue(double printedPages) {
            tonerLevelBlue -= printedPages / 100;
        }

        int getPrintedPages() {
            return printedPages;
        }

        void setPrintedPages(int printedPages) {
            myPrinter.printedPages += printedPages;
        }

        private double getPrinterCondition() {
            return printerCondition;
        }

        void setPrinterCondition(double printedPage) {
            printerCondition -= printedPage / 1000;
        }

        int printDoJob(int copyCount, boolean colorPrint, boolean isDuplex) {
            if (colorPrint)
                if (getTonerLevelBlack() > 0 &&
                        getTonerLevelMagenta() > 0 &&
                        getTonerLevelYellow() > 0 &&
                        getTonerLevelBlue() > 0 &&
                        getPrinterCondition() > 0) {
                    if (isDuplex && copyCount < getPrinterCondition()) {
                        if (colorPrint && isDuplex) {
                            setPrintedPages(copyCount * 2);
                            setTonerLevelBlack(copyCount * 2);
                            setTonerLevelMagenta(copyCount * 2);
                            setTonerLevelBlue(copyCount * 2);
                            setTonerLevelYellow(copyCount * 2);
                            setPrinterCondition(copyCount * 2);
                            return getPrintedPages();
                        } else if (colorPrint && !isDuplex) {
                            setPrintedPages(copyCount);
                            setTonerLevelBlack(copyCount);
                            setTonerLevelMagenta(copyCount);
                            setTonerLevelBlue(copyCount);
                            setTonerLevelYellow(copyCount);
                            setPrinterCondition(copyCount);
                            return getPrintedPages();
                        } else if (!colorPrint && !isDuplex) {
                            setTonerLevelBlack(copyCount);
                            setPrintedPages(copyCount);
                            setPrinterCondition(copyCount);
                            return getPrintedPages();
                        } else if (!colorPrint && isDuplex) {
                            setTonerLevelBlack(copyCount * 2);
                            setPrintedPages(copyCount * 2);
                            setPrinterCondition(copyCount * 2);
                            return getPrintedPages();
                        }
                    } else System.out.println("The printer condition level is low to do that job successfully");
                } else System.out.println("The toners level is low for that job");
            return getPrintedPages();
        }

        private void fixPrinter() {
            printerCondition = 100;
            System.out.println("Printer " + getManufacturer() + " was repaired");
        }

        private void fillUpToner(double tonerLevel, String color) {
            if (color.equals("Black")) {
                if (getTonerLevelBlack() + tonerLevel <= 100) {
                    tonerLevelBlack += tonerLevel;
                    System.out.println("Level of Black toner after filling up is " + tonerLevelYellow + "%");
                } else System.out.println("Level of Black toner after filling up can't be more than 100%");
            } else if (color.equals("Magenta")) {
                if (tonerLevelMagenta + tonerLevel <= 100) {
                    tonerLevelMagenta += tonerLevel;
                    System.out.println("Level of Magenta toner after filling up is " + tonerLevelYellow + "%");
                } else System.out.println("Level of Magenta toner after filling up can't be more than 100%");
            } else if (color.equals("Blue")) {
                if (tonerLevelBlue + tonerLevel <= 100) {
                    tonerLevelBlue += tonerLevel;
                    System.out.println("Level of Blue toner after filling up is " + tonerLevelYellow + "%");
                } else System.out.println("Level of Blue toner after filling up can't be more than 100%");
            } else if (color.equals("Yellow")) {
                if (tonerLevelYellow + tonerLevel <= 100) {
                    tonerLevelYellow += tonerLevel;
                    System.out.println("Level of Yellow toner after filling up is " + tonerLevelYellow + "%");
                } else System.out.println("Level of Yellow toner after filling up can't be more than 100%");
            }
        }
    }
}