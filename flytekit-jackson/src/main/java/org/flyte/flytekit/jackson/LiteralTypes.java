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
package org.flyte.flytekit.jackson;

import static org.flyte.api.v1.LiteralType.ofSimpleType;

import org.flyte.api.v1.LiteralType;
import org.flyte.api.v1.SimpleType;

class LiteralTypes {
  static final LiteralType INTEGER = ofSimpleType(SimpleType.INTEGER);
  static final LiteralType FLOAT = ofSimpleType(SimpleType.FLOAT);
  static final LiteralType STRING = ofSimpleType(SimpleType.STRING);
  static final LiteralType BOOLEAN = ofSimpleType(SimpleType.BOOLEAN);
  static final LiteralType DATETIME = ofSimpleType(SimpleType.DATETIME);
  static final LiteralType DURATION = ofSimpleType(SimpleType.DURATION);
}
