/*
 * Copyright 2021 Flyte Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.flyte.integrationtests.structs;

import com.google.auto.service.AutoService;
import com.google.auto.value.AutoValue;
import org.flyte.flytekit.SdkRunnableTask;
import org.flyte.flytekit.jackson.JacksonSdkType;

@AutoService(SdkRunnableTask.class)
public class MockLookupBqTask
    extends SdkRunnableTask<MockLookupBqTask.Input, MockLookupBqTask.Output> {
  private static final long serialVersionUID = 604843235716487166L;

  public MockLookupBqTask() {
    super(JacksonSdkType.of(Input.class), JacksonSdkType.of(Output.class));
  }

  @AutoValue
  public abstract static class Input {
    public abstract BQReference ref();

    public abstract boolean checkIfExists();

    public static Input create(BQReference ref, boolean checkIfExists) {
      return new AutoValue_MockLookupBqTask_Input(ref, checkIfExists);
    }
  }

  @AutoValue
  public abstract static class Output {
    public abstract boolean exists();

    public static Output create(boolean exists) {
      return new AutoValue_MockLookupBqTask_Output(exists);
    }
  }

  @Override
  public Output run(Input input) {
    return Output.create(input.ref().tableName().contains("table-exists"));
  }
}
