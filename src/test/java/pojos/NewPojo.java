package pojos;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import lombok.Data;
import org.junit.jupiter.api.Test;



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
