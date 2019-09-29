/*
"8*. Write a project named ""Remote Device"". Create a class ""RemoteController""
which will be simulation the real one to control the TV. Create interfaces Device and Volume.
The ""Device"" interface should have methods powerOn(), powerOff(), setChannel(int channel),
and currentChannel();
The ""Volume"" interface should have methods ""upVolume(), downVolume() and mute();
Write an abstract class TVDevice which will be implementing interfaces Volume and Device and
has the fields String modelName and boolean isOn (Tip: You don't need to implement methods from the interface
if you class is abstract).
Write a class ""TV"" which extends the class TVDevice. Implements all the methods.
Write a class RemoteController to control your TV.
Example of the structure in the requirements.
"
 */
public class Lesson58RemoteController {
    public static void main(String[] args) {

        TV myTVPhilips = new TV(7, "Hooilips");
        myTVPhilips.getModelName();
        myTVPhilips.powerOn();
        myTVPhilips.setChannelNumber(7);
        myTVPhilips.upVolume();
        myTVPhilips.upVolume();
        myTVPhilips.downVolume();
        myTVPhilips.mute();
        myTVPhilips.powerOff();
    }

    interface Device {
        static void setChannel(int channel) {
        }

        void powerOn();

        void powerOff();

        void currentChannel();
    }

    interface Volume {
        void upVolume();

        void downVolume();

        void mute();
    }

    interface BadDecision {
        boolean throwTheWindow();
    }

    abstract static class TVDevice implements Device, Volume, BadDecision {
        String modelName;
        boolean isOn;

        abstract void getModelName();
    }

    static class TV extends TVDevice {

        int volumeLevel;
        int channelNumber;
        int maxVolume = 30;
        String modelName;
        boolean cast;

        TV(int maxVolume, String modelName) {
            this.maxVolume = maxVolume;
            this.modelName = modelName;
        }

        int getVolumeLevel() {
            return volumeLevel;
        }

        int getChannelNumber() {
            return channelNumber;
        }

        void setChannelNumber(int channelNumber) {
            this.channelNumber = channelNumber;
            System.out.println("The channel is changed to " + this.channelNumber + "th.");
        }

        @Override
        public void powerOn() {
            isOn = true;
            System.out.println("Device is turned on");
        }

        @Override
        public void powerOff() {
            isOn = false;
            System.out.println("Device is turned off");
        }

        @Override
        public void currentChannel() {
            System.out.println("The current channel: " + channelNumber);
        }

        @Override
        public void upVolume() {
            if (getVolumeLevel() >= 0 && getVolumeLevel() < maxVolume) {
                volumeLevel++;
                System.out.println("The volume is up to " + getVolumeLevel());
            }
        }

        @Override
        public void downVolume() {
            if (getVolumeLevel() > 0) {
                volumeLevel--;
                System.out.println("The volume is down to " + getVolumeLevel());
            }
        }

        @Override
        public void mute() {
            volumeLevel = 0;
            System.out.println("Device is muted");
        }

        @Override
        void getModelName() {
            System.out.println("Your TV is called: " + modelName);
        }

        @Override
        public boolean throwTheWindow() {
            //TODO
        }
    }
}