/*
 * Copyright (C) 2015 Pablo Guardiola Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codemotion2015.workshop.storage;

import com.codemotion2015.workshop.events.EventsPort;
import com.codemotion2015.workshop.modules.vertical.notes.CreateNoteResponse;
import com.codemotion2015.workshop.modules.vertical.notes.NoteDTO;

public class InMemoryStorageAdapter implements StoragePort {
  private final EventsPort eventsPort;

  public InMemoryStorageAdapter(EventsPort eventsPort) {
    this.eventsPort = eventsPort;
  }

  @Override public void createNote(NoteDTO note) {
    eventsPort.broadcast(new CreateNoteResponse(note));
  }
}
