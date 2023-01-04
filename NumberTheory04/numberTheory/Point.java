package numberTheory;

public class Point {
	private String location;
	private double longitude;
	private double latitude;
	
	public Point(double longitude, double latitude, String location) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.location = location;
	}
	/**
	 * @param longitude
	 * @param latitude
	 */
	public Point(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	


	
	
	public double distance(Point point2) {
		double R = 6371;
		double dLat = Math.toRadians(point2.latitude-this.latitude);  // deg2rad below
		double dLon = Math.toRadians(point2.longitude-this.longitude); 
		double a = 
		    Math.sin(dLat/2) * Math.sin(dLat/2) +
		    Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(point2.latitude)) * 
		    Math.sin(dLon/2) * Math.sin(dLon/2)
		    ; 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
		double d = R * c; // Distance in km
		return d;		
	}
	
	/* This works: */
	public double initialBearing(Point point2) {
		// φ1,λ1
		double dLon = Math.toRadians(point2.getLongitude() - this.getLongitude());
		double lat1 = Math.toRadians(this.getLatitude());
		double lat2 = Math.toRadians(point2.getLatitude());
		double x = Math.cos(lat1)*Math.sin(lat2) - 
				Math.sin(lat1)*Math.cos(lat2)*Math.cos(dLon);
		double y = Math.sin(dLon) * Math.cos(lat2);
		double theta = Math.atan2(y, x);
		double brng = (theta*(180/Math.PI) + 360) % 360;
		return brng;		
	}
	
	public static  double initialBearing(Point point1, Point point2) {
		double dLon = Math.toRadians(point2.getLongitude() - point1.getLongitude());
		double lat1 = Math.toRadians(point1.getLatitude());
		double lat2 = Math.toRadians(point2.getLatitude());
		double x = Math.cos(lat1)*Math.sin(lat2) - 
				Math.sin(lat1)*Math.cos(lat2)*Math.cos(dLon);
		double y = Math.sin(dLon) * Math.cos(lat2);
		double theta = Math.atan2(y, x);
		double brng = (theta*(180/Math.PI) + 360) % 360;
		return brng;		
	}
	
	public double finalBearing(Point point2) {
		double initTheta = initialBearing(point2, this);
		double theta = (initTheta + 180) % 360;
		return theta;
	}
	
	public Point midpoint(Point point2) {
		// φ1,λ1
		double dLon = Math.toRadians(point2.getLongitude() - this.getLongitude());
		double lat1 = Math.toRadians(this.getLatitude());
		double lat2 = Math.toRadians(point2.getLatitude());
		double lon1 = Math.toRadians(this.getLongitude());
		double Bx = Math.cos(lat2) * Math.cos(dLon);
		double By = Math.cos(lat2) * Math.sin(dLon);
		double midLat = Math.atan2(Math.sin(lat1) + Math.sin(lat2),
                Math.sqrt( (Math.cos(lat1)+Bx)*(Math.cos(lat1)+Bx) + By*By ) ); 
		double midLon = lon1 + Math.atan2(By, Math.cos(lat2) + Bx);
		midLat = Math.toDegrees(midLat);
		midLon = Math.toDegrees(midLon);
		Point retPoint = new Point(midLon, midLat, "MidPoint");
		return retPoint;
	}
	
	public Point getEndPoint(double bearing, double distance) {
		double R = 6371;
		double brng = Math.toRadians(bearing);	//Degrees to radians
		distance *= 1.852;		//Nautical miles to km
		double lat1 = Math.toRadians(this.latitude);
		double lon1 = Math.toRadians(this.longitude);
		double lat2 = Math.asin( Math.sin(lat1)*Math.cos(distance/R) + Math.cos(lat1)*Math.sin(distance/R)*Math.cos(brng));
		double lon2 = lon1 + Math.atan2(Math.sin(brng)*Math.sin(distance/R)*Math.cos(lat1),Math.cos(distance/R)-Math.sin(lat1)*Math.sin(lat2));
		lat2 = Math.toDegrees(lat2);
		lon2 = Math.toDegrees(lon2);
		Point retPoint = new Point(lon2, lat2, "End Point");
		return retPoint;				
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getLocation() + " " + this.getLongitude() + " " + this.getLatitude();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	
	
	
}
