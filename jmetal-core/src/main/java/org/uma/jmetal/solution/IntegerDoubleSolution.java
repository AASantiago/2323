//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package org.uma.jmetal.solution;

/**
 * Interface representing a solution composed of integers and real values
 *
 * @author Antonio J. Nebro <antonio@lcc.uma.es>
 */
public interface IntegerDoubleSolution extends Solution<Number> {
  public Number getLowerBound(int index) ;
  public Number getUpperBound(int index) ;
  public int getNumberOfIntegerVariables() ;
  public int getNumberOfDoubleVariables() ;
}
