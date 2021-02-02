import attractions.Attraction;
import attractions.Playground;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark() {
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void setStalls(ArrayList<Stall> stalls) {
        this.stalls = stalls;
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> iRevieweds = new ArrayList<>();
        for (Attraction attraction : attractions) {
            iRevieweds.add((IReviewed) attraction);
        }
        for (Stall stall : stalls) {
            iRevieweds.add((IReviewed) stall);
        }
        return iRevieweds;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addVisitedAttraction(attraction);
        attraction.incrementVisitCount();
    }

    public HashMap<String, Integer> getReviews() {
        HashMap<String, Integer> reviewsHash = new HashMap<>();
        ArrayList<IReviewed> allReviews = getAllReviewed();
        for (IReviewed review : allReviews) {
            reviewsHash.put(review.getName(), review.getRating());
        }
        return reviewsHash;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowedPlaces = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof ISecurity && ((ISecurity) attraction).isAllowedTo(visitor)) {
                allowedPlaces.add((IReviewed) attraction);
            } else if (!(attraction instanceof ISecurity)){
                allowedPlaces.add((IReviewed) attraction);
            }
        }

        for (Stall stall : stalls) {
            if (stall instanceof ISecurity && ((ISecurity) stall).isAllowedTo(visitor)) {
                allowedPlaces.add((IReviewed) stall);
            } else if (!(stall instanceof ISecurity)){
                allowedPlaces.add((IReviewed) stall);
            }
        }
        return allowedPlaces;
    }
}
