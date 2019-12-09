// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.pcg;

import upmc.pcg.ui.GameUI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import upmc.pcg.game.Card;
import upmc.pcg.game.Deck;
import upmc.pcg.game.EnergyCard;
import upmc.pcg.game.PokemonCard;


public class Pokedeck
{
  public static void main(String[] args)
  {     
    GameUI game_ui = new GameUI();
    game_ui.start();
   }
 }
