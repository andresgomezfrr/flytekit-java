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
public class BuildBqReference
    extends SdkRunnableTask<BuildBqReference.Input, BuildBqReference.Output> {
  private static final long serialVersionUID = -489898361071672070L;

  public BuildBqReference() {
    super(
        JacksonSdkType.of(BuildBqReference.Input.class),
        JacksonSdkType.of(BuildBqReference.Output.class));
  }

  @Override
  public Output run(Input input) {
    return Output.create(BQReference.create(input.project(), input.dataset(), input.tableName()));
  }

  @AutoValue
  public abstract static class Input {
    abstract String project();

    abstract String dataset();

    abstract String tableName();

    public static Input create(String project, String dataset, String tableName) {
      return new AutoValue_BuildBqReference_Input(project, dataset, tableName);
    }
  }

  @AutoValue
  public abstract static class Output {
    abstract BQReference ref();

    public static Output create(BQReference ref) {
      return new AutoValue_BuildBqReference_Output(ref);
    }
  }
}
