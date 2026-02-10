package id.go.ojk.client.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiUsage {
  public static final String LOGIN = "login";
  public static final String SEND = "send";
  public static final List<String> ALL_FEATURES = new ArrayList<String>();

  static {
    ALL_FEATURES.add(LOGIN);
    ALL_FEATURES.add(SEND);
  }

  private final List<String> grantedFeatures;

  private ApiUsage(List<String> features) {
    this.grantedFeatures = features;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (obj == null || getClass() != obj.getClass())
      return false;

    ApiUsage that = (ApiUsage) obj;
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

  public static ApiUsage none() {
    return new ApiUsage(Collections.emptyList());
  }

  public static ApiUsage login() {
    return new ApiUsage(Arrays.asList(LOGIN));
  }

  public static ApiUsage send() {
    return new ApiUsage(Arrays.asList(SEND));
  }

  public static ApiUsage sendAndLogin() {
    return new ApiUsage(Arrays.asList(LOGIN, SEND));
  }

  public static ApiUsage all() {
    return new ApiUsage(ALL_FEATURES);
  }

  public boolean hasAny(ApiUsage... features) {
    if (features == null || features.length == 0) {
      return false;
    }
    return Arrays.stream(features).flatMap(f -> f.getGrantedFeatures().stream()).anyMatch(grantedFeatures::contains);
  }

  public boolean hasAll(ApiUsage... features) {
    if (features == null || features.length == 0) {
      return false;
    }
    return Arrays.stream(features).flatMap(f -> f.getGrantedFeatures().stream()).allMatch(grantedFeatures::contains);
  }
}
