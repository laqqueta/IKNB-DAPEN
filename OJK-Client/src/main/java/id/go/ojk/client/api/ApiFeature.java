package id.go.ojk.client.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiFeature {
  public static final String LOGIN = "login";
  public static final String SEND = "send";
  public static final List<String> ALL_FEATURES = new ArrayList<String>();

  static {
    ALL_FEATURES.add(LOGIN);
    ALL_FEATURES.add(SEND);
  }

  private final List<String> grantedFeatures;

  private ApiFeature(List<String> features) {
    this.grantedFeatures = features;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (obj == null || getClass() != obj.getClass())
      return false;

    ApiFeature that = (ApiFeature) obj;
    return that.grantedFeatures.equals(this.grantedFeatures);
  }

  @Override
  public String toString() {
    return grantedFeatures.toString();
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  public static ApiFeature none() {
    return new ApiFeature(Collections.emptyList());
  }

  public static ApiFeature login() {
    return new ApiFeature(Arrays.asList(LOGIN));
  }

  public static ApiFeature send() {
    return new ApiFeature(Arrays.asList(SEND));
  }

  public static ApiFeature sendAndLogin() {
    return new ApiFeature(Arrays.asList(LOGIN, SEND));
  }

  public static ApiFeature all() {
    return new ApiFeature(ALL_FEATURES);
  }

  public boolean hasAny(ApiFeature... features) {
    if (features == null || features.length == 0) {
      return false;
    }
    return Arrays.stream(features).flatMap(f -> f.getGrantedFeatures().stream()).anyMatch(grantedFeatures::contains);
  }

  public boolean hasAll(ApiFeature... features) {
    if (features == null || features.length == 0) {
      return false;
    }
    return Arrays.stream(features).flatMap(f -> f.getGrantedFeatures().stream()).allMatch(grantedFeatures::contains);
  }
}
