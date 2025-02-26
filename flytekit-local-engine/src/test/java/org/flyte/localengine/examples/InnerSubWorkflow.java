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
package org.flyte.localengine.examples;

import com.google.auto.service.AutoService;
import org.flyte.flytekit.SdkBindingData;
import org.flyte.flytekit.SdkWorkflow;
import org.flyte.flytekit.SdkWorkflowBuilder;

@AutoService(SdkWorkflow.class)
public class InnerSubWorkflow extends SdkWorkflow {
  @Override
  public void expand(SdkWorkflowBuilder builder) {
    SdkBindingData a = builder.inputOfInteger("a");
    SdkBindingData b = builder.inputOfInteger("b");
    SdkBindingData c =
        builder
            .apply("inner-sum-a-b", new SumTask().withInput("a", a).withInput("b", b))
            .getOutput("c");

    builder.output("result", c);
  }
}
