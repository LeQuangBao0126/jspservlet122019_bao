package api.input;

public class AssignmentBuildingInput {
		private Long buildingId;
		private Long[] staffIds = new Long[] {};
		
		public Long getBuildingId() {
			return buildingId;
		}
		public void setBuildingId(Long buildingId) {
			this.buildingId = buildingId;
		}
		public Long[] getStaffIds() {
			return staffIds;
		}
		public void setStaffIds(Long[] staffIds) {
			this.staffIds = staffIds;
		}
			
}
