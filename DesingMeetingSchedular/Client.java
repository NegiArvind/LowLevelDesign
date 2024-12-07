import java.util.List;

public class Client {

    public static void main(String[] args) {
        MeetingRoomManager meetingRoomManager = new MeetingRoomManager();
        MeetingRoomSchedular meetingRoomSchedular = new MeetingRoomSchedular(meetingRoomManager);
        createMeetingRooms(meetingRoomManager);
        Meeting meeting = getMeeting(3,4,3);
        List<MeetingRoom> meetingRoomList = meetingRoomSchedular.getAvailableMeetingRooms(meeting);
        if(!meetingRoomList.isEmpty()) {
            MeetingRoom selectedMeetingRoom = meetingRoomList.get(0);
            meetingRoomSchedular.bookMeetingRoom(selectedMeetingRoom, meeting.getTimeInterval());
            System.out.println("Booked meeting room -> " + "Meeting room id " + selectedMeetingRoom.getId() +
                    " Capacity " + selectedMeetingRoom.getCapacity());
        } else {
            System.out.println("No available meeting room");
        }
    }

    private static void createMeetingRooms(MeetingRoomManager meetingRoomManager) {
        MeetingRoom meetingRoom1 = new MeetingRoom(1, new Location(1,1), 3);
        MeetingRoom meetingRoom2 = new MeetingRoom(2, new Location(1,1), 4);
        MeetingRoom meetingRoom3 = new MeetingRoom(3, new Location(1,1), 5);
        MeetingRoom meetingRoom4 = new MeetingRoom(4, new Location(1,1), 6);
        MeetingRoom meetingRoom5 = new MeetingRoom(5, new Location(1,1), 5);
        MeetingRoom meetingRoom6 = new MeetingRoom(6, new Location(1,1), 2);
        MeetingRoom meetingRoom7 = new MeetingRoom(7, new Location(1,1), 4);
        MeetingRoom meetingRoom8 = new MeetingRoom(8, new Location(1,1), 3);
        MeetingRoom meetingRoom9 = new MeetingRoom(9, new Location(1,1), 6);
        MeetingRoom meetingRoom10 = new MeetingRoom(10, new Location(1,1), 7);
        MeetingRoom meetingRoom11 = new MeetingRoom(11, new Location(1,1), 6);
        MeetingRoom meetingRoom12 = new MeetingRoom(12, new Location(1,1), 8);

        meetingRoomManager.createMeetingRoom(meetingRoom1);
        meetingRoomManager.createMeetingRoom(meetingRoom2);
        meetingRoomManager.createMeetingRoom(meetingRoom3);
        meetingRoomManager.createMeetingRoom(meetingRoom4);
        meetingRoomManager.createMeetingRoom(meetingRoom5);
        meetingRoomManager.createMeetingRoom(meetingRoom6);
        meetingRoomManager.createMeetingRoom(meetingRoom7);
        meetingRoomManager.createMeetingRoom(meetingRoom8);
        meetingRoomManager.createMeetingRoom(meetingRoom9);
        meetingRoomManager.createMeetingRoom(meetingRoom10);
        meetingRoomManager.createMeetingRoom(meetingRoom11);
        meetingRoomManager.createMeetingRoom(meetingRoom12);
    }

    private static Meeting getMeeting(int startTime, int endTime, int capacity) {
        Meeting meeting = new Meeting();
        TimeInterval timeInterval = new TimeInterval();
        timeInterval.setStartTime(startTime);
        timeInterval.setEndTime(endTime);
        meeting.setTimeInterval(timeInterval);
        meeting.setCapacity(capacity);
        return meeting;
    }
}
