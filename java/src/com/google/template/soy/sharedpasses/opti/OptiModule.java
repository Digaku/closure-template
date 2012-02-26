/*
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.template.soy.sharedpasses.opti;

import com.google.inject.AbstractModule;

/**
 * Guice module for optimization passes.
 *
 * <p> Important: Do not use outside of Soy code (treat as superpackage-private).
 *
 * @author Anthony Jawad
 */
public class OptiModule extends AbstractModule {
  @Override protected void configure() {
    // Bindings for when explicit dependencies are required.
    bind(PreevalVisitorFactory.class);
    bind(PrerenderVisitorFactory.class);
    bind(SimplifyExprVisitor.class);
    bind(SimplifyVisitor.class);
  }
}
