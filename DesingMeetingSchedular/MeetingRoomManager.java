import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MeetingRoomManager {
    private List<MeetingRoom> meetingRoomList;
    private Map<Integer, Calendar> meetingRoomCalendarMap;

    public MeetingRoomManager() {
        this.meetingRoomList = new ArrayList<>();
        this.meetingRoomCalendarMap = new HashMap<>();
    }

    public void createMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoomList.add(meetingRoom);
        meetingRoomCalendarMap.put(meetingRoom.getId(), new Calendar());
    }

    public void removeMeetingRoom(int meetingId) {
        MeetingRoom meetingRoom = meetingRoomList.stream().filter(meetingRoom1 ->
                meetingRoom1.getId() == meetingId).findFirst().orElse(null);
        if(Objects.nonNull(meetingRoom)) {
            meetingRoomList.remove(meetingRoom);
        }
    }

    public List<MeetingRoom> getAvailableMeetingRooms(TimeInterval requestedTimeInterval, int capacity) {
        List<MeetingRoom> meetingRooms = meetingRoomList.stream().filter(meetingRoom
                -> meetingRoom.getCapacity() >= capacity).toList();
        List<MeetingRoom> finalMeetingRooms = new ArrayList<>();
        meetingRooms.forEach(meetingRoom -> {
            Calendar meetingRoomCalendar = meetingRoomCalendarMap.get(meetingRoom.getId());
            if(isGivenMeetingRoomAvailable(meetingRoomCalendar.getTimeIntervals(), requestedTimeInterval)) {
                finalMeetingRooms.add(meetingRoom);
            }
        });
        return finalMeetingRooms;
    }


    public void bookMeetingRoom(int meetingRoomId, TimeInterval timeInterval) {
        Calendar calendar = meetingRoomCalendarMap.get(meetingRoomId);
        List<TimeInterval> existingTimeIntervals = calendar.getTimeIntervals();
        existingTimeIntervals.add(timeInterval);
        calendar.setTimeIntervals(existingTimeIntervals);
        meetingRoomCalendarMap.put(meetingRoomId, calendar);
    }

    private boolean isGivenMeetingRoomAvailable(List<TimeInterval> bookedTimeIntervals, TimeInterval requestedTimeInterval) {
        for(TimeInterval timeInterval: bookedTimeIntervals) {
            if(Math.max(timeInterval.getStartTime(), requestedTimeInterval.getStartTime())
                    < Math.min(timeInterval.getEndTime(), requestedTimeInterval.getEndTime())) {
                return false;
            }
        }
        return true;
    }
}
