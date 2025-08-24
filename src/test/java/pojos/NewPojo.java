package pojos;


import lombok.Data;

@Data
public class NewPojo {
    private Value value;
    private boolean result;
    private String error;

    public static class Value {
        private String applicationId;
        private Object abTestingGroups;
        private Object skipAuth;


        public String getApplicationId() {
            return applicationId;
        }

        public Object getAbTestingGroups() {
            return abTestingGroups;
        }

        public Object getSkipAuth() {
            return skipAuth;
        }
    }
}
