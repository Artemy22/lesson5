import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

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
public class Lesson58 {
    public static void main(String[] args) {
        Lesson58.TV Philips = new TV("PhilipsSmartTV", 12);
        TV.RemoteController newController = new TV.RemoteController();
        System.out.println(Philips.isOn);
        Philips.powerOn();
        System.out.println("Device is turn on");
    }

    interface Device {
        void powerOn();

        void powerOff();

        static void setChannel(int channel);

        void currentChannel();
    }

    interface Volume {
        void upVolume();

        void downVolume();

        void mute();
    }

    abstract static class TVDevice implements Device, Volume {
        String modelName;
        boolean isOn;
    }

    static class TV extends TVDevice {

        int currentVolume = 0;

        int currentChanel;

        String modelName;

        int maxVolume;

        boolean isMuted;

        TV(String modelName, int maxVolume) {
            this.modelName = modelName;
            this.maxVolume = maxVolume;
        }

        static void setChannel(int channel) {
        }

        public int getCurrentVolume() {
            return currentVolume;
        }

        public void setCurrentVolume(int currentVolume) {
            this.currentVolume = currentVolume;
        }

        public int getCurrentChanel() {
            return currentChanel;
        }

        public void setCurrentChanel(int currentChanel) {
            this.currentChanel = currentChanel;
        }

        public String getModelName() {
            return modelName;
        }

        public int getMaxVolume() {
            return maxVolume;
        }

        public boolean isMuted() {
            return isMuted;
        }

        public void setMuted(boolean muted) {
            isMuted = muted;
        }

        public void powerOn() {
        }

        @Override
        public void powerOff() {

        }

        @Override
        public void currentChannel() {
        }

        @Override
        public void upVolume() {

        }

        @Override
        public void downVolume() {

        }

        @Override
        public void mute() {

        }

        static class RemoteController extends TVDevice {

            @Override
            public void powerOn() {
                this.isOn = true;
            }

            @Override
            public void powerOff() {
                this.isOn = false;

            }

            @Override
            public void setChannel(int channel) {
                TV.setChannel(channel);
            }

            @Override
            public void currentChannel() {
                System.out.println("The current chanel: ");
            }

            @Override
            public void upVolume() {
                if (currentVolume < maxVolume) {
                    if (!isMuted) {
                        currentVolume++;
                    } else System.out.println("Device is muted");
                } else System.out.println("The device already has the max volume level.");
            }

            @Override
            public void downVolume() {
                if (currentVolume > 0) {
                    currentVolume--;
                }
            }

            @Override
            public void mute() {
                isMuted = true;
                System.out.println("Device is muted");
            }

            public void unMute() {
                isMuted = false;
                System.out.println("Device is unmuted");
            }

        }
    }
}